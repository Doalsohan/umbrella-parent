package com.umbrella.demo.service.impl;

import com.umbrella.demo.service.RocketMqService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketMqServiceImpl implements RocketMqService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMqMessage() {
        rocketMQTemplate.syncSend("Rocket_Create_Topic","This is a test data");
    }
}
