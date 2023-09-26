package com.umbrella.demo.framework;

import com.umbrella.demo.service.HelloService;
import com.umbrella.demo.service.impl.HelloServiceImpl;

public class DefaultServiceLocator {

    private static HelloService helloService = new HelloServiceImpl();

    public HelloService createHelloServiceInstance() {
        return helloService;
    }
}
