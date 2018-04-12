package org.com.allen.enhance.basic.redis.lettuce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-lettuce-redis.xml")
public class LettuceSpringMain {

    @Autowired
    private PassportRedis passportRedis;

    @Test
    public void testLettuceSet() {
        String cl = passportRedis.getSyncCommands().set("cl", "1");
        System.out.println(cl);
        String cl1 = passportRedis.getSyncCommands().get("cl");
        System.out.println(cl1);
    }
    
}
