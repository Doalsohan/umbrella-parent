package com.umbrella.demo.events;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;


@Component
public class TestEventListener {

    @Async
    @TransactionalEventListener(classes = TestEvent.class)
    public void onMessage(TestEvent testEvent) {
        System.out.println("11111111111111");
    }
}
