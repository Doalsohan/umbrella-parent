package com.umbrella.demo.elastic;


import cn.hutool.core.lang.generator.SnowflakeGenerator;
import cn.hutool.json.JSONUtil;
import com.umbrella.demo.entity.EmployeeBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;


@DataElasticsearchTest
public class ElasticSearchTests {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    void saveEmploy() {
        SnowflakeGenerator generator = new SnowflakeGenerator();
        EmployeeBean build = EmployeeBean.builder().id(generator.next())
                .name("张三")
                .address("恐慌撒当啊扫来")
                .studentCode("GH00001")
                .desc("狂三空哈经发局扣分")
                .mobile("1500000000").build();
        EmployeeBean save = elasticsearchTemplate.save(build);
        System.out.println(JSONUtil.toJsonStr(save));
    }
}
