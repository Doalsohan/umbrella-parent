package com.umbrella.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BullSmallTrumpetOrderPojo {
    private Long id;
    private BigDecimal price;
    private Integer count;
    private String queueKey;
    private Integer order;
}
