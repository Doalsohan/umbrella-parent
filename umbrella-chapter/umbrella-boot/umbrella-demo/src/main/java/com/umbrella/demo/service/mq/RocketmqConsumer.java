package com.umbrella.demo.service.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "Rocket_Create_Topic",consumerGroup = "Rocket_Create_Topic_Group")
public class RocketmqConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }
}
