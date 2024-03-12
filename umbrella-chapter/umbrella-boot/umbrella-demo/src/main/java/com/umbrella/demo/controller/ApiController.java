package com.umbrella.demo.controller;


import com.umbrella.core.api.ResultWrapper;
import com.umbrella.demo.config.VerifySignature;
import com.umbrella.demo.pojo.BurveOrderPojo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/burve")
@AllArgsConstructor
public class ApiController {

    @PostMapping("/sync/order")
    @VerifySignature
    public ResultWrapper<Void> syncOrder(@RequestBody BurveOrderPojo pojo) {
        return ResultWrapper.data(null);
    }
}
