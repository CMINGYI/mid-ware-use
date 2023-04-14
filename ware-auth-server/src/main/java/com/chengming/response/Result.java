package com.chengming.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{


    private Integer code;


    private String message;


    private T data;


    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultCode.FAIL.getCode(), message, null);
    }

    public static  Result<?> failed() {
        return new Result<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null);
    }

    public static Result<?> failed(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static Result<?> failed(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
       return new Result<>(code, message, data);
    }
}
