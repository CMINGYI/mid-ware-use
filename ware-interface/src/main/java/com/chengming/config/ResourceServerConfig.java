package com.chengming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @Name: ResourceServerConfig
 * @Author: kitchening
 * @Date: 2023-03-25 16:40
 * @Description: ResourceServerConfig
 * @Version: V1.0
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 声明了资源服务器的ID是user-service，声明了资源服务器的TokenStore是JWT
     *
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("ware-interface").tokenStore(tokenStore());
    }

    /**
     * 配置TokenStore
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 配置公钥
     *
     * @return
     */
    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.cert");
        String publicKey = null;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            log.error("error:", e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }

    /**
     * 配置了除了/user路径之外的请求可以匿名访问
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**", "/consumer/**").authenticated()
                .antMatchers("/actuator/**", "/actuator**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().permitAll();
    }
}
