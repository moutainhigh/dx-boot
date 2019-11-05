package com.dx.base.lambdatest;

import java.util.stream.Stream;

/**
 * Description: 清单 24. 生产一个等差数列
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class Sequence {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 3)
                .limit(10).forEach(x -> System.out.print(x + " "));// 0 3 6 9 12 15 18 21 24 27
        System.out.println("------------------------------");
        Stream.iterate(4, n -> n + 3)
                .limit(10).forEach(x -> System.out.print(x + " "));// 4 7 10 13 16 19 22 25 28 31



    }
}
