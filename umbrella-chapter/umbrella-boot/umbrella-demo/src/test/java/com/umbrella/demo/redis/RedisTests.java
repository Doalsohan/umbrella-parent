package com.umbrella.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

@DataRedisTest
public class RedisTests {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
}
