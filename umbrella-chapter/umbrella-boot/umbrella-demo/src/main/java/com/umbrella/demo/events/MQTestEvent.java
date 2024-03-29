package com.umbrella.demo.events;

import org.springframework.context.ApplicationEvent;

public class MQTestEvent extends ApplicationEvent {
    public MQTestEvent(Object source) {
        super(source);
    }
}
