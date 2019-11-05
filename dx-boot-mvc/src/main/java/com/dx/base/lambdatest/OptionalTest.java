package com.dx.base.lambdatest;

import java.util.Optional;

/**
 * Description: 清单 14. Optional的两个用例
 * 【使用Optional代码的可读性好，而且它提供的是编译时检查，能极大的降低NPE对程序的影响】
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class OptionalTest {
    public static void main(String[] args) {
        String strA = " abcd", strB = null;
        print(strA);
        print(" ");
        print(strB);
        System.out.println("==============================");
        System.out.println(getLength(strA));
        System.out.println(getLength(" "));
        System.out.println(getLength(strB));
    }

    public static void print(String text) {
        // JDK 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-JDK 8
        if (text != null) {
            System.out.println(text);
        }
    }

    public static int getLength(String text) {
        // JDK 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-JDK 8
        // return (text != null) ? text.length() : -1;
    }
}
