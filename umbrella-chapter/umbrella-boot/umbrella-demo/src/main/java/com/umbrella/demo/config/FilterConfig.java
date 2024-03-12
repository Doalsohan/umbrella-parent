package com.umbrella.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SignatureProps.class)
public class FilterConfig {

    @ConditionalOnBean(SignatureProps.class)
    @Bean
    public FilterRegistrationBean<RequestCachingFilter> registrationBean(RequestCachingFilter requestCachingFilter) {
        FilterRegistrationBean<RequestCachingFilter> bean = new FilterRegistrationBean<>(requestCachingFilter);
        bean.setOrder(1);
        return bean;
    }
}
