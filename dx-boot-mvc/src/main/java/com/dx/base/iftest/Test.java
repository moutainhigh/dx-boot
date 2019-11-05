package com.dx.base.iftest;

import com.dx.base.iftest.util.Function;
import com.dx.base.iftest.util.IfFunction;

import java.util.HashMap;

/**
 * Description: com.dx.iftest
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
public class Test {

    public static void main(String[] args) {

        IfFunction<String> ifFunction = new IfFunction<String>(new HashMap<String, Function>());

        ifFunction.add("1",()-> System.out.println("1"))
                .add("2",()-> System.out.println("2"))
                .add("3",()-> System.out.println("3"));

        ifFunction.doIfWithDefault("4",()-> System.out.println("错误"));

    }
}

