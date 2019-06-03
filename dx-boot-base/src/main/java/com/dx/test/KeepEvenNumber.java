package com.dx.test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Description: 清单 10. 留下偶数
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class KeepEvenNumber {
    public static void main(String[] args) {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(evens));// [2, 4, 6]
    }
}
