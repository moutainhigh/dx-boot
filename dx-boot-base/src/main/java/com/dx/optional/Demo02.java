package com.dx.optional;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Description: com.dx.optional
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/19
 */
public class Demo02 {

    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 如果不是null,调用Consumer
        optional1.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });
    }

}
