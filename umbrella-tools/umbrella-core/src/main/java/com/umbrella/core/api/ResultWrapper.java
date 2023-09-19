package com.umbrella.core.api;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;


public class ResultWrapper <T> implements Serializable {

    private String message;
    private int code;
    private boolean success;
    private T data;

    private ResultWrapper(IResultCode resultCode) {
        this(resultCode,resultCode.getMessage());
    }

    private ResultWrapper(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private ResultWrapper(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private ResultWrapper(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private ResultWrapper(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = ResultCode.SUCCESS.code == code;
    }

    public static boolean isSuccess(ResultWrapper<?> result) {
        return Optional.ofNullable(result).map((x) -> Objects.deepEquals(ResultCode.SUCCESS.code, x.code)).orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(ResultWrapper<?> result) {
        return !isSuccess(result);
    }

    public static <T> ResultWrapper<T> data(T data) {
        return data(data, "操作成功");
    }

    public static <T> ResultWrapper<T> data(T data, String msg) {
        return data(200, data, msg);
    }

    public static <T> ResultWrapper<T> data(int code, T data, String msg) {
        return new ResultWrapper(code, data, data == null ? "暂无数据" : msg);
    }

    public static <T> ResultWrapper<T> success(String msg) {
        return new ResultWrapper(ResultCode.SUCCESS, msg);
    }

    public static <T> ResultWrapper<T> success(IResultCode resultCode) {
        return new ResultWrapper(resultCode);
    }

    public static <T> ResultWrapper<T> success(IResultCode resultCode, String msg) {
        return new ResultWrapper(resultCode, msg);
    }

    public static <T> ResultWrapper<T> fail(String msg) {
        return new ResultWrapper(ResultCode.FAILURE, msg);
    }

    public static <T> ResultWrapper<T> fail(int code, String msg) {
        return new ResultWrapper(code, null, msg);
    }

    public static <T> ResultWrapper<T> fail(IResultCode resultCode) {
        return new ResultWrapper(resultCode);
    }

    public static <T> ResultWrapper<T> fail(IResultCode resultCode, String msg) {
        return new ResultWrapper(resultCode, msg);
    }

    public static <T> ResultWrapper<T> status(boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }

    public int getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
