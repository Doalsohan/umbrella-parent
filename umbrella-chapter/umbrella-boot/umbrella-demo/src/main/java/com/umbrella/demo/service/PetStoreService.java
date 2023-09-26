package com.umbrella.demo.service;

import com.umbrella.demo.entity.Pet;

import java.util.List;

public interface PetStoreService {
    /**
     * 宠物列表
     * @return
     */
    List<Pet> list();

    /**
     * 查询宠物数据
     * @param id
     * @return
     */
    Pet findOne(Long id);
}
