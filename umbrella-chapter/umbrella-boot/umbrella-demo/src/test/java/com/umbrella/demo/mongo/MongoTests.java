package com.umbrella.demo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest
public class MongoTests {
    @Autowired
    private MongoTemplate mongoTemplate;
}
