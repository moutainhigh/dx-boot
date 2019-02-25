package com.dx.producer;

import com.dx.entity.Order;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-24
 */
@Service
@Log
public class OrderSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean send(Order order){

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        log.info("开始发送队列消息。。。");
        rabbitTemplate.convertAndSend("order-exchange",
                "order.123",
                order,
                correlationData);
        log.info("结束发送队列消息。。。");

        return true;
    }

}
