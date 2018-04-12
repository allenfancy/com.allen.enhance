package com.allen.springframework.event;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:spring-event.xml"})
public class EventTest {

    //@Test
    public void testEvent() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-event.xml");
        context.start();
        CustomApplicationEventPublishAware bean = (CustomApplicationEventPublishAware) context.getBean("customApplicationEventPublishAware");
        bean.say();
        context.stop();
        context.close();
    }
}
