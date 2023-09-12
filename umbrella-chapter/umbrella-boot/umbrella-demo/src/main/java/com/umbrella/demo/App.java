package com.umbrella.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }


    @Slf4j
    @Component
    static class ConfigPriorityRunner implements ApplicationRunner {
        @Value("${name}")
        private String name;
        @Override
        public void run(ApplicationArguments args) throws Exception {
            log.info(name);
        }
    }
}
