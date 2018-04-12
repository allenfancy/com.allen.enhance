package com.allen.enhance.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration 
@EnableSwagger2 
@EnableWebMvc 
@ComponentScan(basePackages = {"com.allen.swagger.ehance.controller"}) 
public class SwaggerConfig {
    
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("吴涛", "", "wutao@bilibili.com");
        return new ApiInfoBuilder()
                .title("web接口")
                .description("ASO API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}