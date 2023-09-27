package com.umbrella.demo.sdk.java;

import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        Enumeration<URL> resources = ClassLoaderTest.class.getClassLoader().getResources("config/um.properties");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url.toString());
        }
    }

}
