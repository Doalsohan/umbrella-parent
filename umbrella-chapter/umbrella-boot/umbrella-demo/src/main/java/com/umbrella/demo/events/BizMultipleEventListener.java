package com.umbrella.demo.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class BizMultipleEventListener {

    @Async
    @TransactionalEventListener(classes = MultipleEvent.class)
    public void onMessage(MultipleEvent multipleEvent) {
        log.info("22222222222222222222:{}",multipleEvent.getSource());
    }
}
