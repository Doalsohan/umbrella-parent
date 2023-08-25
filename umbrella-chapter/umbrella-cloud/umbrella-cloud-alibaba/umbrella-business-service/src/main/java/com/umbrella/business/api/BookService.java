package com.umbrella.business.api;

import com.umbrella.business.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> queryBooks();
}
