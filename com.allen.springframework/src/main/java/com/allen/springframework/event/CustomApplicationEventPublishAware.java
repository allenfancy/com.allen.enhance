package com.allen.springframework.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomApplicationEventPublishAware implements ApplicationEventPublisherAware {

    private String cumstom;
    private ApplicationEventPublisher customApplicationEventPublisher;

    public void setCumstom(String cumstom) {
        this.cumstom = cumstom;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.customApplicationEventPublisher = applicationEventPublisher;
    }

    public void say() {
        System.out.println("custom is : " + this.cumstom);
        CustomEvent customEvent = new CustomEvent(new String("custome"));
        this.customApplicationEventPublisher.publishEvent(customEvent);
    }

}
