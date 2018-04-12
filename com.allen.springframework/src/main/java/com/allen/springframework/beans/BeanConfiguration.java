package com.allen.springframework.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import com.allen.springframework.service.UserService;
import com.allen.springframework.service.impl.UserServiceImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("singleton")
    public UserService userService() {
        return new UserServiceImpl();
    }
    
    @Bean
    @Scope("prototype")
    public String getName() {
        return "allen";
    }
}
