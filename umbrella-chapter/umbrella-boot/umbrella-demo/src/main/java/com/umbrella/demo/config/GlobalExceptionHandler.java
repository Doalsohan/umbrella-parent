package com.umbrella.demo.config;


import com.umbrella.core.api.IResultCode;
import com.umbrella.core.api.ResultWrapper;
import com.umbrella.core.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultWrapper bizExceptionHandler(BusinessException e) {
        return ResultWrapper.fail(e.getResultCode(),getMessage(e.getResultCode()));
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultWrapper exceptionHandler( Exception e) {
        return ResultWrapper.fail(e.getMessage());
    }



    private String getMessage(IResultCode resultCode) {
        return messageSource.getMessage(String.valueOf(resultCode.getCode()), null, LocaleContextHolder.getLocale());
    }
}
