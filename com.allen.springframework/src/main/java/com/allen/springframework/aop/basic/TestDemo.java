/*package com.allen.springframework.aop.basic;

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
        logService.log();
        logService.noLog();
    }
}
*/