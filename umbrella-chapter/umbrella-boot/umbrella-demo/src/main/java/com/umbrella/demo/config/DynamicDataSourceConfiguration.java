package com.umbrella.demo.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Primary
//    @Bean(name = "masterDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "slaveDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "dynamicDataSource")
//    public DynamicRoutingDataSource DataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
//                                               @Qualifier("slaveDataSource") DataSource slaveDataSource) {
//        //targetDataSource 集合是我们数据库和名字之间的映射
//        Map<Object, Object> targetDataSource = new HashMap<>();
//        targetDataSource.put(DataSourceKey.MASTER_DATASOURCE.getName(), masterDataSource);
//        targetDataSource.put(DataSourceKey.SLAVE_DATASOURCE.getName(), slaveDataSource);
//        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
//        dataSource.setTargetDataSources(targetDataSource);
//        //设置默认对象
//        dataSource.setDefaultTargetDataSource(masterDataSource);
//        return dataSource;
//    }
//
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource")DataSource dynamicDataSource) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dynamicDataSource);
//        return factoryBean.getObject();
//    }
}
