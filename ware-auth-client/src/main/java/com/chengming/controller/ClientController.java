package com.chengming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Name: CilentController
 * @Author: kitchening
 * @Date: 2023-03-25 20:00
 * @Description: CilentController
 * @Version: V1.0
 */
@RestController
public class ClientController {
    @Autowired
    private OAuth2RestTemplate restTemplate;

    //http://ms.ai-xinxin.cn/auth-server/oauth/authorize?response_type=code&client_id=auth-client&redirect_uri=https://baidu.com
    @GetMapping("/securedPage")
    public ModelAndView securedPage(OAuth2Authentication authentication) {
        return new ModelAndView("securedPage").addObject("authentication", authentication);
    }

    @GetMapping("/remoteCall")
    public String remoteCall() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://ms.ai-xinxin.cn/interface/user/name", String.class);
        return responseEntity.getBody();
    }
}
