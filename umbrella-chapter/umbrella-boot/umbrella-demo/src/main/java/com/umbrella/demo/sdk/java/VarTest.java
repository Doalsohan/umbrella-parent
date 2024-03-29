package com.umbrella.demo.sdk.java;

public class VarTest {

    public static void main(String[] args) {
        VarTest varTest = new VarTest();
        varTest.testStr();
    }


    private void testStr() {
        String str1 = new String("Hello,World");
        String str2 = str1;

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
