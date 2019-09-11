package com.dx.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description: 测试java中的队列和栈
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/4
 */
@Slf4j
public class Basket {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        boolean app1 = blockingQueue.add("app1");

        blockingQueue.put("app2");
        String take = blockingQueue.take();
        blockingQueue.add("app3");
        String take2 = blockingQueue.take();



        log.info("----------------------------------------------------------------");


        Stack<String> stringStack = new Stack<>();

        String app11 = stringStack.push("app1");
        String app12 = stringStack.push("app2");

        log.info(app11);

        log.info(String.valueOf(stringStack.search("app12")));


        log.info(stringStack.pop());


    }


}
