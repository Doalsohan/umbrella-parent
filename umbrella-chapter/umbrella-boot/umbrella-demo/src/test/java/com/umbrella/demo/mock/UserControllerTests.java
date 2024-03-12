package com.umbrella.demo.mock;

import cn.hutool.json.JSONUtil;
import com.umbrella.demo.AppTests;
import com.umbrella.demo.entity.Pet;
import com.umbrella.demo.framework.DefaultServiceLocator;
import com.umbrella.demo.service.EchoService;
import com.umbrella.demo.service.HelloService;
import com.umbrella.demo.service.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserControllerTests extends AppTests {
    @MockBean
    private EchoService echoService;
    @Autowired
    private HelloService helloService;
    @Autowired
    private DefaultServiceLocator serviceLocator;
    /**
     * <p>
     * @BeforeEach：在每个单元测试方法执行前都执行一遍
     * @BeforeAll：在每个单元测试方法执行前执行一遍（只执行一次）
     * @DisplayName("商品入库测试")：用于指定单元测试的名称
     * @Disabled：当前单元测试置为无效，即单元测试时跳过该测试
     * @RepeatedTest(n)：重复性测试，即执行n次
     * @ParameterizedTest：参数化测试，
     * @ValueSource(ints = {1, 2, 3})：参数化测试提供数据
     * </p>
     */
    @BeforeEach
    public void setUp() {
        Mockito.when(echoService.echo(Mockito.any())).thenReturn("看水说："+System.currentTimeMillis());
    }

    @Test
    void echo() throws Exception {
        final String result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/echo/")
                                .param("name", "看山的小屋")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertTrue(result.startsWith("看山"));
    }


    @Test
    void springTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/ApplicationContext.xml");
        PetStoreService storeService = context.getBean(PetStoreService.class);
        List<Pet> list = storeService.list();
        System.out.println(JSONUtil.toJsonStr(list));
    }

    @Test
    void helloServiceTest() {
        String say = helloService.say("hhhhhhh");
        System.out.println(say);

        System.out.println(serviceLocator.createHelloServiceInstance().say("模型的笑容"));
    }

}
