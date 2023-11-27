package com.umbrella.demo.sdk.java.string;

public class StringTest {

    public static void main(String[] args) {
        // 引用类型变量保存的实际是引用类型的地址

        // java中的==和equals()最大的区别是：一个是运算符，一个是方法。
        // ==操作符专门用来比较变量的值是否相同，引用类型对象变量其实是一个引用，
        // 它们的值是指向对象所在的内存地址。equals方法常用来比较对象的内容是否相同，equals()方法存在于Object类中。

        String str1 = new String("abc");

        String str2 = new String("abc");

        System.out.println(str1.equals(str2));

        System.out.println(str1 == str2);

        String str3 = str1;
        System.out.println(str1 == str3);

        str3 = str3 + "sdsafasdasfa";

        System.out.println(str3 == str1);

    }



}
