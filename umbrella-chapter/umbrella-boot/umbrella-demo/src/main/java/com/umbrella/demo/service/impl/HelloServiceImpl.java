package com.umbrella.demo.service.impl;


import com.umbrella.demo.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String world) {
        return world;
    }
}
