package com.umbrella.demo.sdk.java;

public class JvmHello extends Jvm{
    public static String a = "please say sea";

    public static int b = 1;

    public static long c = 2;

    public static char d = 'k';

    public String f = "please bye bye";

    static {
        System.out.println(JvmHello.class);
    }


    {
        System.out.println("<init>");
    }

}
