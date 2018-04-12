package com.allen.springframework.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allen.springframework.beans.BeanConfiguration;
import com.allen.springframework.service.UserService;

public class AnnotationConfigApplicationContextMain {

    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        System.out.println(ctx.getStartupDate());
        UserService bean = ctx.getBean(UserService.class);
        System.out.println(bean);
        String bean2 = ctx.getBean(String.class);
        System.out.println(bean2);
    }
    
}
