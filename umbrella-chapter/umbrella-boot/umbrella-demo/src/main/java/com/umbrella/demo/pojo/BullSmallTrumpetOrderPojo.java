package com.umbrella.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BullSmallTrumpetOrderPojo implements Serializable {
    private Long id;
    private BigDecimal price;
    private Integer count;
    private String queueKey;
    private Integer order;
    private Date createTime;
}
