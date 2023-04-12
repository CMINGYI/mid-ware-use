package com.chengming.config;

import com.chengming.enums.ResultCode;
import com.chengming.reponse.Result;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Name: ControllerExceptionHandler
 * @Author: kitchening
 * @Date: 2023-04-06 22:21
 * @Description: ControllerExceptionHandler 全局异常处理器 多个{@code  @RestControllerAdvice}时 使用{@code @Order} 处理捕获顺序
 * @Version: V1.0
 */
@RestControllerAdvice
public class ControllerExceptionHandler {


    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        if (StringUtils.hasText(msg)) {
            return Result.failed(ResultCode.VALIDATED_FAIL.getCode(), msg);
        }
        return Result.failed(ResultCode.VALIDATED_FAIL);
    }

    /**
     * {@code @PathVariable} 和 {@code @RequestParam} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public Result<?> handleConstraintViolationException(ConstraintViolationException ex) {
        if (StringUtils.hasText(ex.getMessage())) {
            return Result.failed(ResultCode.VALIDATED_FAIL.getCode(), ex.getMessage());
        }
        return Result.failed(ResultCode.VALIDATED_FAIL);
    }

    /**
     * 顶级异常捕获并统一处理，其他异常无法处理时候选择使用
     */
    @ExceptionHandler(Exception.class)
    public Result<?> exceptionHandle(Exception e){
       return Result.failed();
    }
}
