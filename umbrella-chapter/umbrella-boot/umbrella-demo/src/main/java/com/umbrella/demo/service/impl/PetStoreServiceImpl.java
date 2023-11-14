package com.umbrella.demo.service.impl;

import cn.hutool.extra.spring.SpringUtil;
import com.umbrella.demo.entity.Pet;
import com.umbrella.demo.events.TestEvent;
import com.umbrella.demo.service.PetStoreService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class PetStoreServiceImpl implements PetStoreService {
    /**
     * 宠物列表
     *
     * @return
     */
    @Override
    @Transactional
    public List<Pet> list() {
        List<Pet> pets = new ArrayList<>();
        for(long i=1;i<10;i++){
            Pet pet = new Pet();
            pet.setId(i);
            pet.setName("policy" + i);
            pet.setAge(2);
            pet.setColor("灰色");
            pet.setAnimal(Byte.valueOf("1"));
            pet.setBreed(Byte.valueOf("1"));
            pets.add(pet);
        }
        SpringUtil.publishEvent(new TestEvent("dasjd"));
        return pets;
    }

    /**
     * 查询宠物数据
     *
     * @param id
     * @return
     */
    @Override
    public Pet findOne(Long id) {
        return null;
    }
}
