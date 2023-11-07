package com.umbrella.demo.sdk.java;

public class EmojiUtil {

    public static void main(String[] args) {
        String alias = cn.hutool.extra.emoji.EmojiUtil.toAlias("\uD83D\uDE03\uD83D\uDE03");
        System.out.println(alias);
        System.out.println(JvmHello.selfInfo);

        System.out.println(JvmHello.a);
    }

}
