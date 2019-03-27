package com.dx.lambda.test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-22
 */

@FunctionalInterface
interface Imath{
    Integer add(Integer num1,Integer num2);
}

public class TEst {

    public static void main(String[] args) {

        Imath lambda = (x, y) -> x - y;

        Integer asfd = lambda.add(11, 2);

        System.out.println(asfd);

    }
}
