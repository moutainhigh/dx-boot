package com.dx.base.lambdatest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: 转换大写 【.map(String::toUpperCase)】和【map(s -> { return s.toUpperCase(); })】
 *  和 【.map(s -> s.toUpperCase())】
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class ToUpperCase {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "java8", "stream");
        List<String> wordList = stream.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]

        stream = Stream.of("hello", "world", "java8", "stream");
        wordList = stream.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]

        stream = Stream.of("hello", "world", "java8", "stream");
        wordList = stream.map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]
    }
}
