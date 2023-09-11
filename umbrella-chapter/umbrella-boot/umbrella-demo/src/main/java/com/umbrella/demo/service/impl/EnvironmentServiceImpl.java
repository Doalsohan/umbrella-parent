package com.umbrella.demo.service.impl;

import com.umbrella.demo.entity.Environment;
import com.umbrella.demo.repository.EnvironmentRepository;
import com.umbrella.demo.service.EnvironmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    @Resource
    private EnvironmentRepository environmentRepository;

    @Override
    public Environment recordEnvironment(Environment environment) {
        return environmentRepository.save(environment);
    }
}
