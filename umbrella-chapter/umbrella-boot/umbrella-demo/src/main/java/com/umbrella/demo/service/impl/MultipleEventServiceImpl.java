package com.umbrella.demo.service.impl;

import cn.hutool.extra.spring.SpringUtil;
import com.umbrella.demo.events.MultipleEvent;
import com.umbrella.demo.service.MultipleEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultipleEventServiceImpl implements MultipleEventService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void multipleListener() {
        SpringUtil.publishEvent(new MultipleEvent("sdbsahgjsahd"));
    }
}
