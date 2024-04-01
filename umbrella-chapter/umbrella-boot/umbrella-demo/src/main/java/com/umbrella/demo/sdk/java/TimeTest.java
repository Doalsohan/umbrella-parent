package com.umbrella.demo.sdk.java;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Objects;

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


        BigDecimal divide = BigDecimal.valueOf(30).add(BigDecimal.valueOf(50)).add(BigDecimal.valueOf(80))
                .divide(BigDecimal.valueOf(30),4, RoundingMode.DOWN);

        System.out.println(divide);



        DateTime pledgeAt = DateUtil.beginOfDay(DateUtil.date());
        System.out.println(pledgeAt);
        LocalDateTime periodEndLocalDateTime = DateUtil.toLocalDateTime(pledgeAt).plusDays(30);
        DateTime periodEndAt = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(periodEndLocalDateTime)));
        System.out.println(periodEndAt);
        LocalDateTime pledgeStopLocalDateTimeAt = DateUtil.toLocalDateTime(periodEndAt).plusDays(1);
        DateTime pledgeStopAt = DateUtil.endOfDay(DateUtil.parseDateTime(DateUtil.formatLocalDateTime(pledgeStopLocalDateTimeAt)));
        System.out.println(pledgeStopAt);


        boolean b = Objects.deepEquals(new BigDecimal("123.456"), new BigDecimal("123.457"));
        System.out.println(b);


        int x = 5;
        x = x + 1;
        {
            x = x*2;
            System.out.println(x);
        }
        System.out.println(x);


        System.out.println(fbl(5));


        System.out.println(DateUtil.yesterday());

        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));




        //方法一
        long milliSecondsLeftToday = 86400000 - DateUtils.getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE);
        long secondsLeftToday = 86400 - DateUtils.getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE);
        System.out.println("当天剩余毫秒1：" + milliSecondsLeftToday);
        System.out.println("当天剩余秒1：" + secondsLeftToday);



        //方法三:LocalDateTime和ChronoUnit为1.8新增
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long millSeconds = ChronoUnit.MILLIS.between(LocalDateTime.now(),midnight);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        System.out.println("当天剩余毫秒3：" + millSeconds);
        System.out.println("当天剩余秒3：" + seconds);
    }



    public static int fbl(int n) {
        if(n <= 1){
            return n;
        } else {
            return fbl(n-1) + fbl(n-2);
        }
    }


}
