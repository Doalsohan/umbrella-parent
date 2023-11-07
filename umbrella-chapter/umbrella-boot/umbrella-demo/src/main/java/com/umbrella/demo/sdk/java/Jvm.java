package com.umbrella.demo.sdk.java;

public class Jvm {

    public static String selfInfo = Jvm.class.getName();

    static {
        System.out.println("Hello, JVM");
    }

    {
        System.out.println("I am Jvm, i need init");
    }
}
