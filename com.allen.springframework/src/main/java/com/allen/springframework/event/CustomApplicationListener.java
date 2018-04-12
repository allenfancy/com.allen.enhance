package com.allen.springframework.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class CustomApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.getClass().getName());
        if (event instanceof ContextStartedEvent) {
            System.out.println("context start");
            System.out.println(event.getSource() + " " + event.getTimestamp());
            System.out.println("==========");
        }
        if (event instanceof ContextClosedEvent) {
            System.out.println("context closed");
            System.out.println(event.getSource() + " " + event.getTimestamp());
            System.out.println("==========");
        }
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("context refreshed");
            System.out.println(event.getSource() + " " + event.getTimestamp());
            System.out.println("==========");
        }
        if (event instanceof ContextStoppedEvent) {
            System.out.println("context stopped");
            System.out.println(event.getSource() + " " + event.getTimestamp());
            System.out.println("==========");
        }
        if (event instanceof CustomEvent) {
            System.out.println(event.getSource() + " " + event.getTimestamp());
            System.out.println("==========");
        }
    }

}
