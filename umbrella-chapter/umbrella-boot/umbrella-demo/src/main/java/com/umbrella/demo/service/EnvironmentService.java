package com.umbrella.demo.service;

import com.umbrella.demo.entity.Environment;

import java.util.List;

public interface EnvironmentService {

    Environment recordEnvironment(Environment environment);


    List<Environment> list();

}
