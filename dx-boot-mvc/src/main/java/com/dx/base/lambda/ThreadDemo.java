package com.dx.base.lambda;

public class ThreadDemo {

    public static void main(String[] args) {
        Object target = new Runnable() {

            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) target).start();

        // jdk8 lambda
        Object target2 = (Runnable) () -> System.out.println("ok");
        Runnable target3 = () -> System.out.println("ok");
        System.out.println(target2 == target3); // false

        new Thread((Runnable) target2).start();


        System.out.println("-----------------------");


        new Thread(() -> {
            System.out.println("11");
            System.out.println("11");
            System.out.println("11");
        }).start();


    }

}
