package org.com.allen.enhance.basic.writeAndRead.plan2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {

    public DynamicDataSourceGlobal value() default DynamicDataSourceGlobal.READ;
}
