package com.dx.base.lambdatest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: 清单 8. 平方数 (map 生产的是个1:1的映射，每个输入元素，都按照规则转换成另一个元素)
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class ToSquare {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4).stream();
        List<Integer> squareList = stream.map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareList.toString());// [1, 4, 9, 16]
    }
}
