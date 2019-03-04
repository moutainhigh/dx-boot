package com.dx.test;

import com.dx.entity.Order;
import com.dx.producer.OrderSend;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class OrderSendTest {

    @Autowired
    private OrderSend orderSend;

    @Test
    public void send(){

        Order order = new Order();
        order.setId("20190200101111");
        order.setName("衣物订单");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID());

        boolean flag = orderSend.send(order);

        log.info("结果是：" + flag);


    }

}
