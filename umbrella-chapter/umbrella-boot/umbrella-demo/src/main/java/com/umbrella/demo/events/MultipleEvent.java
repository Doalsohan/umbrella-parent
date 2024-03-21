package com.umbrella.demo.events;

import org.springframework.context.ApplicationEvent;

public class MultipleEvent extends ApplicationEvent {
    public MultipleEvent(Object source) {
        super(source);
    }
}
