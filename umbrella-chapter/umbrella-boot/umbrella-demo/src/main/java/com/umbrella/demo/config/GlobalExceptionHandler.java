package com.umbrella.demo.config;


import com.umbrella.core.api.ResultWrapper;
import com.umbrella.core.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultWrapper bizExceptionHandler(BusinessException e) {
        return ResultWrapper.fail(e.getResultCode());
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
}
