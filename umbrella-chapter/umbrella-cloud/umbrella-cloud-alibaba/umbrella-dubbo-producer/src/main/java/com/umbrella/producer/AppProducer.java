package com.umbrella.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AppProducer {
    public static void main( String[] args ) {
        SpringApplication.run(AppProducer.class,args);
    }
}
