package com.chengming.config;

import com.chengming.reponse.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Name: ControllerExceptionHandler
 * @Author: kitchening
 * @Date: 2023-04-06 22:21
 * @Description: ControllerExceptionHandler
 * @Version: V1.0
 */
@ResponseBody
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response<String> exceptionHandle(Exception e){
        Response<String> response = new Response<>();
        response.setCode(300);
        response.setMsg("服务处理错误！！！");
        return response;
    }
}
