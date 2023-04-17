package com.chengming.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.chengming.response.Result;
import io.micrometer.core.lang.NonNull;
import io.micrometer.core.lang.Nullable;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Name: ResultAdvice
 * @Author: kitchening
 * @Date: 2023-04-13 22:49
 * @Description: ResultAdvice
 * @Version: V1.0
 */
@RestControllerAdvice
public class ResultAdviceConfig implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @Nullable Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果不需要进行封装的，可以添加一些校验手段，比如添加标记排除的注解
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType,
                                  @Nullable Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (body == null) {
            return Result.success("");
        }
        // 提供一定的灵活度，如果body已经被包装了，就不进行包装
        if (body instanceof Result){
            return body;
        }
        if (body instanceof String) {
            return body;
        }
        return Result.success(body);
    }

    /**
     * todo: 待处理
     * @return
     */
//    @Bean
//    public HttpMessageConverters httpMessageConverter() {
//        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
//    }
}
