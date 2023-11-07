package com.umbrella.demo.sdk.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    public static void main(String[] args) {

        String specialCharacter = "[_`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
        String word = "[a-zA-Z]";
        String number = "[0-9]";

        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("^");
        regexBuilder.append("[");
        regexBuilder.append("(").append(word).append("&").append(number).append(")");
        regexBuilder.append("|");
        regexBuilder.append("(").append(word).append("&").append(specialCharacter).append(")");
        regexBuilder.append("|");
        regexBuilder.append("(").append(number).append("&").append(specialCharacter).append(")");
        regexBuilder.append("|");
        regexBuilder.append("(").append(word).append("&").append(number).append("&").append(specialCharacter).append(")");
        regexBuilder.append("]");
        regexBuilder.append("+");
        regexBuilder.append("$");

        String input = "34-_hfgh";

        String regex = regexBuilder.toString();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input); // 获取 matcher 对象

        System.out.println(m.matches());
    }
}
