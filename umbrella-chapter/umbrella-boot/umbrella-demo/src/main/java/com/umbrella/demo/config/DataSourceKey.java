package com.umbrella.demo.config;

import lombok.Getter;

public enum DataSourceKey {

    MASTER_DATASOURCE("masterDataSource"),

    SLAVE_DATASOURCE("salveDataSource");

    @Getter
    private String name;


    DataSourceKey(String name) {
        this.name = name;
    }
}
