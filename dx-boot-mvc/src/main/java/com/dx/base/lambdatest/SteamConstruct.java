package com.dx.base.lambdatest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: 清单 4. 构造流的几种常见方法
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class SteamConstruct {
    public static void main(String[] args) {
        // 1. Individual values 单独值
        Stream stream = Stream.of("a1", "b1", "c1");
        stream.forEach(System.out::print);//打印 a1b1c1

        // 2. Arrays 数组
        String[] strArray = new String[]{"a2", "b2", "c2"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        System.out.println(stream.collect(Collectors.joining(",")).toString());//打印 a2,b2,c2

        // 3. Collections 集合
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }
}
