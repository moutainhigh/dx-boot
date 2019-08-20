package com.dx.dateutil;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Description: com.dx.dateutil
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/6
 */
public class Demo01 {

    public static void main(String[] args) {
        //2019-03-31
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);


        // 15:56:36.232
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);


        // 2019-03-31T15:56:36.233
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


        // 2019-03-31T07:56:36.233Z
        Instant instant = Instant.now();
        System.out.println(instant);


        // 获取当前的时间戳（毫秒）
        long instantMilli = instant.toEpochMilli();
        System.out.println(instantMilli);

        // 一个小时后的时间=加了一个小时时间
        Instant plus1Hours = instant.plus(1, ChronoUnit.HOURS);
        // 计算两个时间之间的时间量
        long until = instant.until(plus1Hours, ChronoUnit.SECONDS);
        System.out.println(until);


        // 一个小时前的时间=减了一个小时
        Instant minus1Hours = instant.minus(1, ChronoUnit.HOURS);
        System.out.println(minus1Hours);


        // Instant转换成java.util.Date类型
        Date date = Date.from(instant);
        System.out.println("date" + date);


        // java.util.Date转换成Instant类型
        Instant dateInstant = date.toInstant();
        System.out.println(dateInstant);


        // 当天开始时间
        LocalDateTime start = LocalDateTime.of(localDate, LocalTime.MIN);
        // 当天结束时间
        LocalDateTime end = LocalDateTime.of(localDate, LocalTime.MAX);
        System.out.println(start);
        System.out.println(end);


        // 计算两个时间之间的时间量度
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.getSeconds());
        // 格式化初始指定时间
        System.out.println(LocalDateTime.parse("2019-03-01 11:10:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));





        LocalDateTime parse = LocalDateTime.parse("2019-03-01 11:10:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String format = parse.format(DateTimeFormatter.ofPattern("yyyy-MM-"));
        System.out.println(format);


        //LocalDateTime --> Date

        Date date1 = Date.from(parse.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(date1);


        //Date --> LocalDateTime

        LocalDateTime localDateTime2 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(localDateTime2);


        Instant instant1 = date1.toInstant();
        ZonedDateTime zonedDateTime = instant1.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);


        System.out.println("-----------------------------------");



    }


}
