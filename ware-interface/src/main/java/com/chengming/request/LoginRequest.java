package com.chengming.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Name: LoginRequest
 * @Author: kitchening
 * @Date: 2023-04-13 22:17
 * @Description: LoginRequest
 * @Version: V1.0
 */

@Data
@ApiModel("登录请求")
public class LoginRequest {

    @ApiModelProperty(value = "用户名", required = true)
    private String account;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
