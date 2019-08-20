package com.dx.client;

/**
 * Description: com.dx.client
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/15
 */
class Singleton {
    public static int counter1;
    public static int counter2 = 2;
    private static Singleton sin = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return sin;
    }

}

class Test {
    public static void main(String[] args) {
        Singleton sin = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}


