package com.umbrella.demo.service.impl;

import com.umbrella.demo.config.CommonUtils;
import com.umbrella.demo.config.Constants;
import com.umbrella.demo.pojo.BullSmallTrumpetOrderPojo;
import com.umbrella.demo.service.BullSmallTrumpetOrderService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class BullSmallTrumpetOrderServiceImpl implements BullSmallTrumpetOrderService {
    @Autowired
    private RedissonClient redissonClient;
    @Override
    public void handlePrice(BullSmallTrumpetOrderPojo orderPojo) {
        log.info("orderPojo:{}",orderPojo);
        BigDecimal price = orderPojo.getPrice();
        RBucket<BigDecimal> bucket = redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_LATEST_PRICE_KEY));
        bucket.set(price, Duration.of(24, ChronoUnit.HOURS));
        RBucket<BigDecimal> bucket1 = redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_CURRENT_PRICE_KEY));
        BigDecimal upgradePrice = price.multiply(new BigDecimal("0.05")).setScale(4, RoundingMode.DOWN);
        BigDecimal bigDecimal = price.add(upgradePrice);
        bucket1.set(bigDecimal, Duration.of(24, ChronoUnit.HOURS));
        log.info("price:{},upgradePrice:{},currentPrice:{}",price,upgradePrice,bigDecimal);


        RBucket<BullSmallTrumpetOrderPojo> bucketOne = redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_LATEST_ORDER_ONE_HOUR_KEY));
        bucketOne.set(orderPojo,Duration.of(1, ChronoUnit.HOURS));
        RBucket<BullSmallTrumpetOrderPojo> bucketSix = redissonClient.getBucket(CommonUtils.dailyRedisKey(Constants.BULL_DAILY_LATEST_ORDER_SIX_HOUR_KEY));
        bucketSix.set(orderPojo,Duration.of(6, ChronoUnit.HOURS));
    }
}
