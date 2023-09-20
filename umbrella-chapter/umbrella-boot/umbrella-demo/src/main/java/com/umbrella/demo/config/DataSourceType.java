package com.umbrella.demo.config;

import lombok.Getter;

public enum DataSourceType {

    MASTER_DATASOURCE("masterDataSource"),

    SLAVE_DATASOURCE("salveDataSource");

    @Getter
    private String name;


    DataSourceType(String name) {
        this.name = name;
    }
}
