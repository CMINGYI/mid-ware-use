package com.chengming.controller;

import com.chengming.component.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Name: UserController
 * @Author: kitchening
 * @Date: 2023-03-25 16:44
 * @Description: UserController
 * @Version: V1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserComponent userComponent;

    @Resource
    private TokenStore tokenStore;


    /*
     * 读权限或写权限可访问，返回登录用户名
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAuthority('READ') or hasAuthority('WRITE')")
    @GetMapping("name")
    public String name(OAuth2Authentication authentication) {
        return authentication.getName();
    }
    /*
     * 读权限或写权限可访问，返回登录用户信息
     * @param authentication
     * @return
     */

    @PreAuthorize("hasAuthority('READ') or hasAuthority('WRITE')")
    @GetMapping
    public OAuth2Authentication read(OAuth2Authentication authentication) {
        return authentication;
    }

    /*
     * 只有写权限可以访问，返回访问令牌中的额外信息
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping
    public Object write(OAuth2Authentication authentication) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        return accessToken.getAdditionalInformation().getOrDefault("userDetails", null);
    }

    @PostMapping("/sayHello")
    public String sayHello() {
        return userComponent.sayHello();
    }
}
