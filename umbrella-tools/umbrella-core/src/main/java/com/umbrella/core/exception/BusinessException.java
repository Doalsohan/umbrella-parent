package com.umbrella.core.exception;

import com.umbrella.core.api.IResultCode;
import com.umbrella.core.api.ResultCode;

public class BusinessException extends RuntimeException {

    protected IResultCode resultCode;

    public BusinessException() {
        super(ResultCode.INTERNAL_SERVER_ERROR.getMessage());
    }

    public BusinessException(IResultCode resultCode) {
        super(resultCode.getMessage());
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(IResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(IResultCode resultCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(resultCode.getMessage(), cause, enableSuppression, writableStackTrace);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IResultCode getResultCode() {
        return resultCode;
    }
}
