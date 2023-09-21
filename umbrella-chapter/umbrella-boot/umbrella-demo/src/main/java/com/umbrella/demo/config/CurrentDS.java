package com.umbrella.demo.config;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface CurrentDS {
    DataSourceKey value() default DataSourceKey.MASTER_DATASOURCE;
}
