package com.umbrella.demo.controller;


import com.umbrella.core.api.ResultWrapper;
import com.umbrella.demo.entity.Environment;
import com.umbrella.demo.service.EnvironmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/list")
    public ResultWrapper<List<Environment>> list() {
        List<Environment> list = environmentService.list();
        return ResultWrapper.data(list);
    }
}
