package com.dx.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: com.dx.base.regex
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/8
 */
public class MachTest {

    public static void main(String[] args) {

        String DATE_STRING  = "好的不知道3se34x3V4-34e43434343";

        String P_COMM = "([a-zA-Z0-9-]{5})-([a-zA-Z0-9-]{5})";

        Pattern pattern = Pattern.compile(P_COMM);
        Matcher matcher = pattern.matcher(DATE_STRING);

        while (matcher.find()){
            int i = 0;
            System.out.println("Found value: " + matcher.group(i));
            i++;
        }




//        String DATE_STRING = "2017-04-25";
//        final String P_COMM = "(\\d{4})-((\\d{2})-(\\d{2}))";
//
//        Pattern pattern = Pattern.compile(P_COMM);
//        Matcher matcher = pattern.matcher(DATE_STRING);
//        matcher.find();//必须要有这句
//
//
//        System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));



    }
}
