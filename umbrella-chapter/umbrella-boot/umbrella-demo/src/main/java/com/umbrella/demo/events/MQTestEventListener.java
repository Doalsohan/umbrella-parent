package com.umbrella.demo.events;

import com.umbrella.demo.config.Constants;
import com.umbrella.demo.pojo.BullSmallTrumpetOrderPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MQTestEventListener {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Async
    @EventListener(classes = MQTestEvent.class)
    public void onMQSend(MQTestEvent testEvent) {
        BullSmallTrumpetOrderPojo orderPojo = (BullSmallTrumpetOrderPojo)testEvent.getSource();
        Message<BullSmallTrumpetOrderPojo> message = MessageBuilder.withPayload(orderPojo)
                        .build();
        rocketMQTemplate.syncSendOrderly(Constants.MQ_TEST_TOPIC,message,"queueKey");
    }

}
