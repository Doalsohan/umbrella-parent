package com.umbrella.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BurveOrderPojo{
    private Long orderId;
    private String userAddress;
    private BigDecimal amount;
    private String coinType;
    private BigDecimal fee;
}
