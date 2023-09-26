package com.umbrella.demo.controller;

import com.umbrella.core.api.ResultCode;
import com.umbrella.core.api.ResultWrapper;
import com.umbrella.core.exception.BusinessException;
import com.umbrella.demo.entity.Pet;
import com.umbrella.demo.service.PetStoreService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {

    private final PetStoreService petStoreService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id) {
//        return new User(1L, "lyTongXue");
        throw new BusinessException(ResultCode.FAILURE);
    }


    @GetMapping("/list")
    public ResultWrapper<List<Pet>> pets() {
        return ResultWrapper.data(petStoreService.list());
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
