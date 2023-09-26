package com.umbrella.demo.entity;

import lombok.Data;

@Data
public class Pet {

    private Long id;

    private String name;

    private Integer age;

    private Byte animal;

    private Byte breed;

    private String color;
}
