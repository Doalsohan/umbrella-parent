package com.umbrella.demo;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.spring.EnableSpringUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.umbrella.demo.config.CommonUtils;
import com.umbrella.demo.config.Constants;
import com.umbrella.demo.events.MQTestEvent;
import com.umbrella.demo.framework.UmbrellaSpringApplicationHook;
import com.umbrella.demo.pojo.BullSmallTrumpetOrderPojo;
import com.umbrella.demo.service.MultipleEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
@EnableScheduling
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
        @Autowired
        private RedissonClient redissonClient;
        @Value("${name}")
        private String name;
        @Override
        public void run(ApplicationArguments args) throws Exception {
            log.info(name);
            BigDecimal bigDecimal = RandomUtil.randomBigDecimal();
            redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_PRICE_KEY)).set(bigDecimal);
            redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_CURRENT_PRICE_KEY)).set(bigDecimal);
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


    @Component
    @AllArgsConstructor
    static class ScheduleConfig {

        private final MultipleEventService multipleEventService;
        private final AtomicInteger atomicInteger = new AtomicInteger();
        private final RedissonClient redissonClient;

//        @Scheduled(cron = "*/5 * * * * ?")
//        public void doSchedule() {
//            multipleEventService.multipleListener();
//        }

//        @Scheduled(cron = "*/5 * * * * ?")
        public void sendOrder() {
            RBucket<BigDecimal> bucket = redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_CURRENT_PRICE_KEY));
            BullSmallTrumpetOrderPojo bullSmallTrumpetOrder = BullSmallTrumpetOrderPojo.builder()
                    .id(new SnowflakeGenerator().next())
                    .price(bucket.get().setScale(4, RoundingMode.DOWN))
                    .count(RandomUtil.randomInt(1, 99))
                    .queueKey("BULL_SMALL_TRUMPET_ORDER")
                    .order(atomicInteger.getAndIncrement())
                    .build();
            SpringUtil.publishEvent(new MQTestEvent(bullSmallTrumpetOrder));
        }
    }
}
