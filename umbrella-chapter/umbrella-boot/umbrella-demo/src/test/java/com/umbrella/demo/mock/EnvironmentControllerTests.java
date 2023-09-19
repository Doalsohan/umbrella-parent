package com.umbrella.demo.mock;

import cn.hutool.json.JSONUtil;
import com.umbrella.core.api.ResultWrapper;
import com.umbrella.demo.AppTests;
import com.umbrella.demo.entity.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.nio.charset.Charset;

public class EnvironmentControllerTests extends AppTests {

    @Test
    @DisplayName("保存环境数据")
    void saveEnv() throws Exception{
        Environment environment = Environment.builder().id(snowflakeGenerator.next())
                .windPower(BigDecimal.valueOf(231.38))
                .humidity(BigDecimal.valueOf(231.73))
                .illumination(BigDecimal.valueOf(231.43))
                .temperature(BigDecimal.valueOf(231.23))
                .build();
        String content = mockMvc.perform(MockMvcRequestBuilders.post("/api/env/save")
                        .content(JSONUtil.toJsonPrettyStr(environment))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.defaultCharset());

        Assertions.assertEquals(JSONUtil.toBean(content, ResultWrapper.class).getCode(),200);
    }



    @Test
    @DisplayName("环境列表")
    void listEnv() throws Exception{
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/api/env/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.defaultCharset());

        Assertions.assertEquals(JSONUtil.toBean(content, ResultWrapper.class).getCode(),200);
    }
}
