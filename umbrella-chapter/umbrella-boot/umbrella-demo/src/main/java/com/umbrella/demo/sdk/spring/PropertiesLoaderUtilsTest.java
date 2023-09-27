package com.umbrella.demo.sdk.spring;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoaderUtilsTest {

    public static void main(String[] args) throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties("config/um.properties");
        properties.forEach((key,value)-> System.out.println(key + "=" + value));
    }
}
