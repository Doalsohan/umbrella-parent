package com.umbrella.demo.config;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.CryptoException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.AuthorizationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
@ConditionalOnBean(SignatureProps.class)
public class RequestSignatureAspect implements PointCutDef{
    private static final String APP_KEY = "app_key";
    private static final String REQUEST_SIGNATURE = "signature";
    private static final String TIMESTAMP = "timestamp";
    private static final String NONCE = "nonce";
    private final SignatureManager signatureManager;
    private final RedisTemplate<String,String> redisTemplate;

    public RequestSignatureAspect(SignatureManager signatureManager,RedisTemplate<String,String> redisTemplate) {
        this.signatureManager = signatureManager;
        this.redisTemplate = redisTemplate;
    }

    @Pointcut("@annotation(VerifySignature)")
    public void annotatedMethod() {
    }

    @Pointcut("@within(VerifySignature)")
    public void annotatedClass() {
    }

    @Before("apiMethod() && (annotatedMethod() || annotatedClass())")
    public void verifySignature() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        String appKey = request.getHeader(APP_KEY);
        if (ObjectUtils.isEmpty(appKey)) {
            throw new AuthorizationException("不受信任的调用方"); // 不受信任的调用方
        }

        // 从请求头中提取签名，不存在直接驳回
        String signature = request.getHeader(REQUEST_SIGNATURE);
        if (ObjectUtils.isEmpty(signature)) {
            throw new RuntimeException("无效签名"); // 无效签名
        }

        // 请求过期校验
        String timestamp = request.getHeader(TIMESTAMP);
        Date date = new Date(Long.parseLong(timestamp));
        long minutes = DateUtil.between(date, DateUtil.date(), DateUnit.MINUTE, true);
        if(minutes > 5) {
            throw new RuntimeException("请求已过期");
        }

        // 重复请求校验
        String nonce = request.getHeader(NONCE);
        String str = redisTemplate.boundValueOps(nonce).get();
        if(StrUtil.isNotBlank(str)){
            throw new RuntimeException("重复请求");
        }
        redisTemplate.boundValueOps(nonce).set("SUCCESS",5, TimeUnit.MINUTES);

        // 提取请求参数
        String requestParamsStr = extractRequestParams(request);
        // 验签。验签不通过抛出业务异常
        verifySignature(appKey, requestParamsStr, signature);
    }

    @SuppressWarnings("unchecked")
    public String extractRequestParams(HttpServletRequest request) {
        // @RequestBody
        String body = null;
        // 验签逻辑不能放在拦截器中，因为拦截器中不能直接读取body的输入流，否则会造成后续@RequestBody的参数解析器读取不到body
        // 由于body输入流只能读取一次，因此需要使用ContentCachingRequestWrapper包装请求，缓存body内容，但是该类的缓存时机是在@RequestBody的参数解析器中
        // 因此满足2个条件才能使用ContentCachingRequestWrapper中的body缓存
        // 1. 接口的入参必须存在@RequestBody
        // 2. 读取body缓存的时机必须在@RequestBody的参数解析之后，比如说：AOP、Controller层的逻辑内。注意拦截器的时机是在参数解析之前的
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
            body = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        }

        // @RequestParam
        Map<String, String[]> paramMap = request.getParameterMap();

        // @PathVariable
        ServletWebRequest webRequest = new ServletWebRequest(request, null);
        Map<String, String> uriTemplateVarNap = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

        return CommonUtils.extractRequestParams(body, paramMap, uriTemplateVarNap);
    }

    /**
     * 验证请求参数的签名
     */
    public void verifySignature(String callerID, String requestParamsStr, String signature) {
        try {
            boolean verified = signatureManager.verifySignature(callerID, requestParamsStr, signature);
            if (!verified) {
                throw new CryptoException("The signature verification result is false.");
            }
        } catch (Exception ex) {
            log.error("Failed to verify signature", ex);
            throw new AuthorizationException("签名验证失败"); // 转换为业务异常抛出
        }
    }

}
