package com.allen.springframework.aop.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-aop.xml"})
public class TestDemo {
    
    @Autowired
    private LogService logService;

    @Test
    public void testAdminOnly() {
        logService.saveLog("context");

    }

    @Test
    public void testAdminOnly1() {
        logService.saveLog2(12243L);
    }
    @Test
    public void testAdminOnly2() {
        logService.noArg();
    }

}
