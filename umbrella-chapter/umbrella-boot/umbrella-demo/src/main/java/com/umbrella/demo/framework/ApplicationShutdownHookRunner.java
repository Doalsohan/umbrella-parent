package com.umbrella.demo.framework;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdownHookRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("ApplicationShutdownHookRunner::SHOUT_DOWN");
        }));
    }
}
