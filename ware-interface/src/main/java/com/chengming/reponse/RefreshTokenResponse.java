package com.chengming.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Name: RefreshTokenResponse
 * @Author: kitchening
 * @Date: 2023-04-13 22:24
 * @Description: RefreshTokenResponse
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResponse {


    private String refreshToken;


    private String token;
}
