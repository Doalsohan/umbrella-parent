package com.umbrella.demo;

import cn.hutool.extra.spring.EnableSpringUtil;
import com.umbrella.demo.framework.UmbrellaSpringApplicationHook;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
@EnableAsync
@EnableSpringUtil
@ImportResource(locations = "classpath:/config/ApplicationContext.xml")
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.withHook(new UmbrellaSpringApplicationHook(),()-> System.out.println("Starting SpringApp-Hook"));
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


    @Configuration
    static class WebConfig implements WebMvcConfigurer {
        @Bean
        public LocaleResolver localeResolver() {
            AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
            localeResolver.setSupportedLocales(Arrays.asList(LocaleUtils.toLocale("zh"),LocaleUtils.toLocale("en")));
            return localeResolver;
        }

    }
}
