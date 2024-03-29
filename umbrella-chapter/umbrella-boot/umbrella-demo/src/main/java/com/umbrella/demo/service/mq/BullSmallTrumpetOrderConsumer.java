package com.umbrella.demo.service.mq;

import com.umbrella.demo.config.Constants;
import com.umbrella.demo.pojo.BullSmallTrumpetOrderPojo;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = Constants.MQ_TEST_TOPIC,consumerGroup = "Rocket_Bull_Trumpet_Topic_Group",consumeMode = ConsumeMode.ORDERLY)
public class BullSmallTrumpetOrderConsumer implements RocketMQListener<BullSmallTrumpetOrderPojo> {
    @Override
    public void onMessage(BullSmallTrumpetOrderPojo s) {
        System.out.println(s);
    }
}
