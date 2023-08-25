package com.umbrella.business.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BookDTO implements Serializable {
    private Long id;
    private String author;
    private String publisher;
    private String title;
    private String description;
}
