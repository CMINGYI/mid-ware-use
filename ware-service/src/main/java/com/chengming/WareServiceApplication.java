package com.chengming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Name: WareServiceApplication
 * @Author: kitchening
 * @Date: 2023-03-25 17:01
 * @Description: WareServiceApplication
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableFeignClients
public class WareServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareServiceApplication.class, args);
    }

}
