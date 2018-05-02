package org.com.allen.enhance.springboot.controller;

import org.com.allen.enhance.springboot.model.Info;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.*;
import java.lang.management.ManagementFactory;


@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/getBean", method = RequestMethod.GET)
    public boolean testMXBean() throws MalformedObjectNameException, InstanceNotFoundException, ReflectionException, AttributeNotFoundException, MBeanException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Object value = mBeanServer.getAttribute(new ObjectName("org.com.allen.enhance.springboot:type=Test,name=Allen-Test"), "Ready");
        return Boolean.class.cast(value);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public @ResponseBody Object testInfo() {
        throw new RuntimeException("null point exception");
       // return Info.builder().name("allen").age(27).version("1.0.0").build();
    }
}
