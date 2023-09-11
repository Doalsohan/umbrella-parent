package com.umbrella.demo.repository;

import com.umbrella.demo.entity.Environment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnvironmentRepository extends MongoRepository<Environment, Long> {

}
