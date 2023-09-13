package com.umbrella.demo.service;

import com.umbrella.demo.entity.TestStock;

public interface TestStockService {
    /**
     * @param goodsNum 商品编号
     * @param buyCount 购买数量
     */
    void buyGoods(String goodsNum, Integer buyCount);
}
