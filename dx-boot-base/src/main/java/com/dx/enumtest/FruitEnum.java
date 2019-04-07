package com.dx.enumtest;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-04-03
 */
public enum FruitEnum {
    APPLE{
        @Override
        public void say() {
            System.out.printf("ok");
        }
    };
    public abstract  void say();

    public static void main(String[] arg) {
        FruitEnum.APPLE.say();
    }

}
