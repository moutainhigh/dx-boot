package com.dx.lambdatest;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class MyTest01 {

    public static void main(String[] args) {

        Random random = new Random();

        Stream.iterate(
                random.nextInt(5), x -> random.nextInt(5)).limit(10).forEach(System.out::println);


        List<Integer> collect = Stream.iterate(random.nextInt(5), x -> random.nextInt(5)).limit(10).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println("random : " + integer);
        }


    }

}
