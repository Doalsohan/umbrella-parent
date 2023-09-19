package com.umbrella.demo.controller;


import com.umbrella.core.api.ResultWrapper;
import com.umbrella.demo.entity.Environment;
import com.umbrella.demo.service.EnvironmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/env")
@AllArgsConstructor
public class EnvironmentController {

    private final EnvironmentService environmentService;

    @PostMapping("/save")
    public ResultWrapper<Long> save(@RequestBody Environment environment) {
        Environment recorded = environmentService.recordEnvironment(environment);
        return ResultWrapper.data(recorded.getId());
    }
}
