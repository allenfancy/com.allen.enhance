package com.allen.springframework.aop.basic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminOnly {
    
    String value() default "admin";
}
