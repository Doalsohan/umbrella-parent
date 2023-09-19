package com.umbrella.demo.controller;

import com.umbrella.core.api.IResultCode;
import com.umbrella.core.api.ResultCode;
import com.umbrella.core.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id) {
//        return new User(1L, "lyTongXue");
        throw new BusinessException(ResultCode.FAILURE);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private Long id;
        private String name;
    }
}
