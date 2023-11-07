package com.umbrella.demo.sdk.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static final String REGEX_NUMBER = "[0-9]*";

    public static final String REGEX_NUMBER_CHAR = "^[A-Za-z0-9]+$";

    public static final String REGEX_CHAR = "^[a-z]+$";

    public static final String REGEX_SPECIAL_CHAR = "^[([a-zA-Z]&[0-9])|([a-zA-Z]&[_`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-])|([0-9]&[_`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-])|([a-zA-Z]&[0-9]&[_`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-])]+$";

    public static void main(String[] args) {
       RegexTest regexTest = new RegexTest();
       System.out.println(regexTest.match("23213123",REGEX_SPECIAL_CHAR));
       System.out.println(regexTest.match("2321sdfsaf3123",REGEX_SPECIAL_CHAR));
       System.out.println(regexTest.match("sdewdcswd",REGEX_SPECIAL_CHAR));
       System.out.println(regexTest.match("$%%$^&**(()",REGEX_SPECIAL_CHAR));



    }

    private boolean match(String str,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
