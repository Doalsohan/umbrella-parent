package com.umbrella.demo.tools;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.umbrella.demo.AppTests;
import com.umbrella.demo.config.SignatureManager;
import com.umbrella.demo.pojo.BurveOrderPojo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ToolsTest extends AppTests {
    @Autowired
    private SignatureManager signatureManager;
    private static final String APP_KEY = "burve";
    private static String sign;
    private static String nonce;
    private static Long timestamp;
    @BeforeEach
    public void setUp() {
        nonce = UUID.randomUUID().toString();
        timestamp = System.currentTimeMillis();
        BurveOrderPojo pojo = BurveOrderPojo.builder()
                .orderId(176898762037293L)
                .userAddress("0x00ec1af91be62e313832b207ad4d4f9544d4eea7")
                .amount(BigDecimal.valueOf(56.2457))
                .coinType("BULL")
                .fee(BigDecimal.valueOf(1.2345))
                .build();
        String rawData = JSONUtil.toJsonStr(pojo);
        sign = signatureManager.sign(APP_KEY, rawData);
        log.info("rawData_GG:{},sign_GG:{}",rawData,sign);
    }


    @Test
    public void testApi() throws Exception {
        BurveOrderPojo pojo = BurveOrderPojo.builder()
                .orderId(176898762037293L)
                .userAddress("0x00ec1af91be62e313832b207ad4d4f9544d4eea7")
                .amount(BigDecimal.valueOf(56.2457))
                .coinType("BULL")
                .fee(BigDecimal.valueOf(1.2345))
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("signature",sign);
        headers.add("nonce",nonce);
        headers.add("timestamp",StrUtil.toString(timestamp));
        headers.add("app_key","burve");
        final String result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/burve/sync/order")
                                .headers(headers)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JSONUtil.toJsonStr(pojo))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertTrue(result.startsWith("看山"));
    }
}
