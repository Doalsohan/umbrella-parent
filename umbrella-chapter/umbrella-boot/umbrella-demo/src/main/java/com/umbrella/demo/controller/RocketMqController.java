package com.umbrella.demo.controller;

import com.umbrella.demo.service.RocketMqService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RocketMqController {

    private final RocketMqService rocketMqService;


    @PostMapping("/rocketmq/post")
    public void sendMessage() {
        rocketMqService.sendMqMessage();
    }
}
