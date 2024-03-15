package com.umbrella.demo.sdk.java;

import cn.hutool.core.util.HexUtil;

import java.math.BigInteger;

public class EmojiUtil {

    public static void main(String[] args) {
        String alias = cn.hutool.extra.emoji.EmojiUtil.toAlias("\uD83D\uDE03\uD83D\uDE03");
        System.out.println(alias);
        System.out.println(JvmHello.selfInfo);

        System.out.println(JvmHello.a);

        BigInteger bigInteger = new BigInteger("3d0490458ee3118ead7c2a90702cb574209442c5",16);
        BigInteger mod = bigInteger.mod(new BigInteger("4"));
        System.out.println(mod.intValue());
    }

}
