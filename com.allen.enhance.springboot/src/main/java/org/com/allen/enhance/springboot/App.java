package org.com.allen.enhance.springboot;

import org.springframework.boot.admin.SpringApplicationAdminMXBeanRegistrar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.management.MalformedObjectNameException;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = App.class )
public class App {

    public static void main(String[] args) {

        new SpringApplicationBuilder(App.class).properties("spring.config.name=allen-test")
                .run(args);
    }


    @Bean
    public SpringApplicationAdminMXBeanRegistrar customerMXBeanRegistrar() throws MalformedObjectNameException {
        return new SpringApplicationAdminMXBeanRegistrar("org.com.allen.enhance.springboot:type=Test,name=Allen-Test");
    }
}
