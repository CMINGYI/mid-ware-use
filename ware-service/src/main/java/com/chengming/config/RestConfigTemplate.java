package com.chengming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Name: RestConfigTemplate
 * @Author: kitchening
 * @Date: 2023-04-06 22:26
 * @Description: RestConfigTemplate
 * @Version: V1.0
 */
@Configuration
public class RestConfigTemplate {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory simpleClientHttpRequestFactory) {
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        return new SimpleClientHttpRequestFactory();
    }
}
