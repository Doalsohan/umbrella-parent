package com.umbrella.demo.service.impl;

import com.umbrella.demo.entity.Environment;
import com.umbrella.demo.repository.EnvironmentRepository;
import com.umbrella.demo.service.EnvironmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EnvironmentServiceImpl implements EnvironmentService {

    private final EnvironmentRepository environmentRepository;

    @Override
    public Environment recordEnvironment(Environment environment) {
        return environmentRepository.save(environment);
    }
}
