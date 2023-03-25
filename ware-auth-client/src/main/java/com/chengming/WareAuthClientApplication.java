package com.chengming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Name: WareAuthClientApplication
 * @Author: kitchening
 * @Date: 2023-03-25 16:21
 * @Description: WareAuthClientApplication
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
public class WareAuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareAuthClientApplication.class, args);
    }
}
