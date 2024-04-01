package com.umbrella.demo.sdk.java.thread;

import com.umbrella.demo.config.Constants;
import com.umbrella.demo.pojo.BullSmallTrumpetOrderPojo;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class PollingThread implements Runnable, InitializingBean {
    private static final AtomicInteger COUNTER_HOUR = new AtomicInteger();
    private static final AtomicInteger COUNTER_SIX_HOUR = new AtomicInteger();
    public static final String UPDATE = "update";
    public static final String RESET = "reset";
    @Autowired
    private RedissonClient redisTemplate;
    @Override
    public void run() {
        for(;;){
            try {
                if(COUNTER_SIX_HOUR.get() >= 3600L*6){
                    doChangePrice(Constants.BULL_DAILY_LATEST_ORDER_SIX_HOUR_KEY,COUNTER_SIX_HOUR,3600L*6,RESET);
                } else {
                    doChangePrice(Constants.BULL_DAILY_LATEST_ORDER_ONE_HOUR_KEY, COUNTER_HOUR, 3600L, UPDATE);
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     */
    @Override
    public void afterPropertiesSet() {
        Thread thread = new Thread(this,"Polling-Thread");
        thread.setDaemon(Boolean.TRUE);
        thread.start();
    }


    /**
     * 更改价格
     * @param key
     * @param counter
     * @param duration
     * @param type
     */
    private void doChangePrice(String key,AtomicInteger counter,Long duration,String type) {
        RBucket<BullSmallTrumpetOrderPojo> bucket = redisTemplate.getBucket(key);
        if(Objects.isNull(bucket.get())) {
            int seconds = counter.incrementAndGet();
            if(seconds >= duration ){
                log.info("{}事件",type);
                counter.set(0);
            }
        } else {
            counter.set(0);
        }
    }
}
