package com.umbrella.demo.mongo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.generator.SnowflakeGenerator;
import cn.hutool.json.JSONUtil;
import com.umbrella.demo.entity.Environment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;

@DataMongoTest
public class MongoTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void insertEnv() {
        SnowflakeGenerator generator = new SnowflakeGenerator();
        Environment environment = Environment.builder().id(generator.next())
                .windPower(BigDecimal.valueOf(231.38))
                .humidity(BigDecimal.valueOf(231.73))
                .illumination(BigDecimal.valueOf(231.43))
                .temperature(BigDecimal.valueOf(231.23))
                .creatAt(DateUtil.date())
                .build();
        mongoTemplate.insert(environment);
    }


    @Test
    void queryEnv() {
        Criteria criteria = Criteria
                .where("createAt")
                .gte(DateUtil.beginOfDay(DateUtil.date()))
                .lte(DateUtil.endOfDay(DateUtil.date()));
        Query query = new Query(criteria);
        List<Environment> environments = mongoTemplate.find(query, Environment.class);
        System.out.println(JSONUtil.toJsonStr(environments));
    }
}
