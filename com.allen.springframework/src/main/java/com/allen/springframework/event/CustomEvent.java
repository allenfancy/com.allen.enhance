package com.allen.springframework.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String eventName;

    public CustomEvent(String eventName) {
        super(eventName);
    }

    public String getEventName() {
        return eventName;
    }
}
