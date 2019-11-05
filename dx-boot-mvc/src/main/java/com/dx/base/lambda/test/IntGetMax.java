package com.dx.base.lambda.test;

import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-03-19
 */
public class IntGetMax {

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 1, 3, 5, 7, 7, 4, 2, 1, 5, 67, 8, 2, 4};

        long t1 = System.currentTimeMillis();


        for (int i = 0; i < 10000; i++) {
            int temp = 0;
            for (int num : nums) {
                if (num > temp) {
                    temp = num;
                }
            }
            System.out.println(" a: " + temp);
        }

        long t2 = System.currentTimeMillis();


        for (int i = 0; i < 10000; i++) {
            int asInt = IntStream.of(nums).parallel().max().getAsInt();
            System.out.println(" b: " + asInt);
        }


        long t3 = System.currentTimeMillis();


        System.out.println(t2 - t1);


        System.out.println(t3 - t2);

    }

}

