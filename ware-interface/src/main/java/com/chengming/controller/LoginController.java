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


    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public Result<String> authLogin(@RequestBody LoginRequest request) {
        String token = "";
        if ("admin".equals(request.getAccount())) {
         token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODE0MDIzNTgsImlhdCI6NzMwMCwicm9sZUNvZGVzIjpbIjdiOWVkYjgyLTdmY2QtNGJhYy1iOWY5LTNmNzVjOGY2ZTRkNTk4OCIsIjdiOWVkYjgyLTdmY2QtNGJhYy1iOWY5LTNmNzVjOGY2ZTRkOTkiXSwidXNlckFjY291bnQiOiJhZG1pbiIsInVzZXJJZCI6NTV9.Mm-0vy9ukC_aA6bA-GxHNsMZkY5N-VdabemITdUAkko";
        }
        return Result.success(token);
    }


    @GetMapping("/refreshToken")
    public Result<RefreshTokenResponse> refreshToken(@RequestBody LoginRequest request) {
        return Result.success(new RefreshTokenResponse("",""));
    }

}
