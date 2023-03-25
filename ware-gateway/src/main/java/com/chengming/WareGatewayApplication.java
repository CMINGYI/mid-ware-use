package com.chengming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Name: WareGatewayApplication
 * @Author: kitchening
 * @Date: 2023-03-25 16:32
 * @Description: WareGatewayApplication
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WareGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareGatewayApplication.class, args);
    }
}
