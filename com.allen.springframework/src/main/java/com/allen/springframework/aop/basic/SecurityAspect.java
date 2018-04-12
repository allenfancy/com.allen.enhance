/*package com.allen.springframework.aop.basic;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Pointcut("@annotation(com.allen.springframework.aop.basic.AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void before() {
        System.out.println("开始执行之前 ... ");
        AdminOnly findAnnotation = AnnotationUtils.findAnnotation(LogService.class, AdminOnly.class);
        System.out.println(findAnnotation);

    }
}
*/