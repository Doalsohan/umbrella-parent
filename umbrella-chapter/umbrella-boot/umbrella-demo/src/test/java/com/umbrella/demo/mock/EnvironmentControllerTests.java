package com.umbrella.demo.mock;

import cn.hutool.json.JSONUtil;
import com.umbrella.demo.AppTests;
import com.umbrella.demo.entity.Environment;
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
                .windPower(BigDecimal.valueOf(231.33))
                .humidity(BigDecimal.valueOf(231.33))
                .illumination(BigDecimal.valueOf(231.33))
                .temperature(BigDecimal.valueOf(231.33))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/env/save")
                .content(JSONUtil.toJsonPrettyStr(environment))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.defaultCharset());
    }
}
