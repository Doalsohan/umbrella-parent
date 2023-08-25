package com.umbrella.producer.service;

import com.umbrella.business.api.BookService;
import com.umbrella.business.dto.BookDTO;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

@DubboService
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDTO> queryBooks() {
        BookDTO build = BookDTO.builder()
                .id(123456L)
                .author("汪曾祺")
                .publisher("民族出版社")
                .title("看见平凡")
                .description("吊框辅导费洞口")
                .build();
        return Arrays.asList(build);
    }
}
