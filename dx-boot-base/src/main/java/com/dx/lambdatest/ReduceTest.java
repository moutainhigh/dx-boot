package com.dx.lambdatest;

import java.util.stream.Stream;

/**
 * Description: 清单 15. reduce的用例
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class ReduceTest {
    public static void main(String[] args) {
        // 1. 求和 SUM 10
        Integer sum = Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        sum = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum); //有起始值
        sum = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get(); //无起始值
        // 2. 最小值 minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double::min).get();
        // 2. 最大数值 maxValue = 1.0
        double maxValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MIN_VALUE, Double::max);
        maxValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double::max).get();
        // 3. 字符串连接 Concat "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 4. 过滤和字符串连接 Filter & Concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
    }
}
