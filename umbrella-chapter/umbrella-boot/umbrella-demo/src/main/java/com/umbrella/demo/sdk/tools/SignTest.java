package com.umbrella.demo.sdk.tools;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

import java.security.KeyPair;

public class SignTest {

    public static void main(String[] args) {

        KeyPair keyPair = SecureUtil.generateKeyPair(SignAlgorithm.SHA256withRSA.getValue());
        System.out.println("privateKey: " + Base64.encode(keyPair.getPrivate().getEncoded()));

        System.out.println("----------------------------------------------");

        System.out.println("publicKey: " + Base64.encode(keyPair.getPublic().getEncoded()));
        System.out.println("----------------------------------------------");

        System.out.println("aesKey: " + Base64.encode(SecureUtil.aes().getSecretKey().getEncoded()));
    }
}
