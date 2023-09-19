package com.umbrella.demo.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.umbrella.demo.entity.TestStock;
import com.umbrella.demo.entity.example.TestStockExample;
import com.umbrella.demo.mapper.TestStockMapper;
import com.umbrella.demo.service.TestStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TestStockServiceImpl implements TestStockService {
    private final TestStockMapper testStockMapper;

    /**
     * @param goodsNum 商品编号
     * @param buyCount 购买数量
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buyGoods(String goodsNum, Integer buyCount) {
        TestStockExample example = TestStockExample.newAndCreateCriteria()
                .andGoodsNumEqualTo(goodsNum).example();
        TestStock testStock = testStockMapper.selectOneByExample(example);
        if(Objects.isNull(testStock) || testStock.getStock() < buyCount) {
            throw new RuntimeException("库存不足");
        }

    }
}
