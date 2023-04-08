package com.chengming.config;

import org.apache.commons.compress.utils.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name: SwaggerConfig
 * @Author: kitchening
 * @Date: 2023-03-25 17:16
 * @Description: SwaggerConfig
 * @Version: V1.0
 */
@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class SwaggerConfig {

    private static final String TOKEN = "token";
    @Bean
    public Docket createRestApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameterList = Lists.newArrayList();
        Parameter parameter = parameterBuilder.modelRef(new ModelRef("String"))
                .name(TOKEN).parameterType("header")
                .required(false).build();
        parameterList.add(parameter);
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chengming.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("ware-service")
                                .description("接口详情")
                                .version("1.0")
                                .contact(
                                        new Contact("易成名", "", "2019131420@qq.com")
                                ).build()

                ).globalOperationParameters(parameterList)
                .securitySchemes(getSecuritySchemes());
    }


    private List<ApiKey> getSecuritySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        ApiKey apiKey = new ApiKey(TOKEN, TOKEN, "header");
        apiKeys.add(apiKey);
        return apiKeys;
    }
}
