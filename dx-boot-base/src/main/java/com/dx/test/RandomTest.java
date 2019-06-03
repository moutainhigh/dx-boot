package com.dx.test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Description: 清单 22. 生产10个随机整数
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class RandomTest {
    public static void main(String[] args) {
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(seed::nextInt)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("--------------------------");
        // Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100))
                .limit(10)
                .forEach(System.out::println);
    }
}