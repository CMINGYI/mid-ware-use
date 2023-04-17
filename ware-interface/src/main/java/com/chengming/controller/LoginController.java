package com.chengming.controller;

import com.chengming.reponse.RefreshTokenResponse;
import com.chengming.reponse.Result;
import com.chengming.request.LoginRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name: LoginController
 * @Author: kitchening
 * @Date: 2023-04-13 22:14
 * @Description: LoginController
 * @Version: V1.0
 */
@RestController
@RequestMapping("/auth")
public class LoginController {


    @GetMapping("/refreshToken")
    public Result<RefreshTokenResponse> refreshToken(@RequestBody LoginRequest request) {
        return Result.success(new RefreshTokenResponse("",""));
    }

}
