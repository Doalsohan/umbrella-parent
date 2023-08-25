package com.umbrella.consumer;

import cn.hutool.json.JSONUtil;
import com.umbrella.business.api.BookService;
import com.umbrella.business.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AppConsumer {
    public static void main( String[] args ) {
        SpringApplication.run(AppConsumer.class,args);
    }

    @Slf4j
    @Component
    static class ServiceRunner implements ApplicationRunner {
        @DubboReference
        private BookService bookService;
        @Override
        public void run(ApplicationArguments args) throws Exception {
            List<BookDTO> bookDTOS = bookService.queryBooks();
            log.info("bookDTOS:{}", JSONUtil.toJsonStr(bookDTOS));
        }
    }
}
