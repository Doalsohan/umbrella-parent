package com.umbrella.demo.sdk.java;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.util.Date;

public class TimeTest {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now().plusDays(31));

        DateTime dateTime = DateUtil.beginOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(LocalDateTime.now())));
        System.out.println(dateTime);


        DateTime endDate = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(LocalDateTime.now().plusDays(30))));
        System.out.println(endDate);

        DateTime endDate1 = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(LocalDateTime.now().plusDays(31))));
        System.out.println(endDate1);



        DateTime pledgeAt = DateUtil.beginOfDay(DateUtil.date());
        System.out.println(pledgeAt);
        LocalDateTime periodEndLocalDateTime = DateUtil.toLocalDateTime(pledgeAt).plusDays(30);
        DateTime periodEndAt = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(periodEndLocalDateTime)));
        System.out.println(periodEndAt);
        LocalDateTime pledgeStopLocalDateTimeAt = DateUtil.toLocalDateTime(periodEndAt).plusDays(1);
        DateTime pledgeStopAt = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(pledgeStopLocalDateTimeAt)));
        System.out.println(pledgeStopAt);
    }
}
