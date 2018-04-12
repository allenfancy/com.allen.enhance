package com.allen.springframework.aop.demo2;

import com.allen.springframework.aop.basic.AdminOnly;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *  匹配参数类型为Long 并且在demo2的包下的东西
 *  @Pointcut("args(Long) && within(com.allen.springframework.aop.demo2.*)")
 *
 *  匹配save的所有方法，并且参数为string 开始
 *  @Pointcut("execution(* *..save*(String,..))")
 *
 */
@Component
@Aspect
public class ArgsAspectConfig {

    @Pointcut("execution(* *..save*(..))")
    public void matchArgs(){}

    @Around("matchArgs()")
    public void before(ProceedingJoinPoint point) throws Throwable {
        Method[] methods = point.getTarget().getClass().getMethods();
        for (Method method : methods) {
            AdminOnly annotation = AnnotationUtils.findAnnotation(method, AdminOnly.class);
            if (annotation != null) {
                if ("admin".equals(annotation.value())) {
                    System.out.println("admin can exec ... ");
                    point.proceed();
                }else {
                    return;
                }
            }
        }

    }
}
