package com.dx.base.dateutil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description: com.dx.dateutil
 *      Date <--> LocalDateTime 相互转化
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/19
 */
public class Demo02 {

    public static void main(String[] args) {

        LocalDate parse = LocalDate.parse("2019-8-19", DateTimeFormatter.ofPattern("yyyy-M-d"));

        LocalDateTime localDateTime = parse.atStartOfDay();

        LocalDateTime localDateTime1 = localDateTime.plusDays(1);

        System.out.println(localDateTime);

    }

}
