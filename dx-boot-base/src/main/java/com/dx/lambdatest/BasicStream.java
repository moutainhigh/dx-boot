package com.dx.lambdatest;

import java.util.stream.IntStream;

/**
 * Description: 清单 5. 数值流的构造(对于基本数值型，
 *  目前有三种对应的包装类型Stream: 1. IntStream 2. LongStream 3. DoubleStream )
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class BasicStream {
    // IntStream, LongStream, DoubleStream. 当然我们也可以用Stream<Integer>, Stream<Long>, Stream<Double>,
    // 但是boxing 和 unboxing会很耗时, 所以特别为这三个基本数值型提供了对应的Stream
    public static void main(String[] args) {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);// 123
        System.out.println("---------------------------");
        IntStream.range(1, 3).forEach(System.out::print);// [1,3) 12

        System.out.println("---------------------------");
        IntStream.rangeClosed(1, 3).forEach(System.out::print);// [1,3] 123


        System.out.println("---------------------------#########");
        IntStream.range(1,9).limit(1).forEach(System.err::println);
    }
}
