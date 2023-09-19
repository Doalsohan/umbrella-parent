package com.umbrella.demo;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
@Slf4j
@AutoConfigureMockMvc
@SpringBootTest(args = "--app.test=one",webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTests {
    @Autowired
    protected MockMvc mockMvc;
    protected SnowflakeGenerator  snowflakeGenerator;

    @BeforeEach
    private void setUp() {
        snowflakeGenerator = new SnowflakeGenerator();
    }
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
    @Test
    void contextLoads() {
    }


    @Test
    void applicationArgumentsPopulated(@Autowired ApplicationArguments args) {
        assertThat(args.getOptionNames()).containsOnly("app.test");
        assertThat(args.getOptionValues("app.test")).containsOnly("one");
    }


    @Test
    @DisplayName("assertTrue断言测试")
    void testEquals() {
        Assertions.assertTrue(3<4);

    }

    @Test
    @DisplayName("测试断言NotNull")
    void testNotNull() {
        assertNotNull(new Object());
    }


    @Test
    @DisplayName("测试断言抛异常")
    void testThrows() {
        ArithmeticException arithExcep = assertThrows(ArithmeticException.class, () -> {
            int m = 5/0;
        });
        assertEquals("/ by zero", arithExcep.getMessage());
    }


    @Test
    @DisplayName("测试断言超时")
    void testTimeOut() {
        String actualResult = assertTimeout(ofSeconds(2), () -> {
            Thread.sleep(1000);
            return "a result";
        });
        System.out.println(actualResult);
    }



    @Test
    @DisplayName("测试组合断言")
    void testAll() {
        assertAll("测试item商品下单",
                () -> {
                    //模拟用户余额扣减
                    assertTrue(1 < 2, "余额不足");
                },
                () -> {
                    //模拟item数据库扣减库存
                    assertTrue(3 < 4);
                },
                () -> {
                    //模拟交易流水落库
                    assertNotNull(new Object());
                }
        );
    }


    @RepeatedTest(3)
    @DisplayName("重复测试")
    void repeatedTest() {
        System.out.println("调用");
    }



    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("参数化测试")
    void paramTest(int a) {
        assertTrue(a > 0 && a < 4);
    }
}
