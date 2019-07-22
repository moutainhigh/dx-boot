package com.dx.producer;

import com.dx.constant.Constants;
import com.dx.repository.mapper.BrokerMessageLogMapper;
import com.dx.repository.po.BrokerMessageLogPO;
import com.dx.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 订单消息发送者<br>
 * 描述: 订单消息发送者<br>
 * 时间: 2018/09/06<br>
 *
 */
@Slf4j
@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    /**
     * 回调方法：confirm确认
     */
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            log.info("correlationData的数据是：" + correlationData);
            String messageId = correlationData.getId();
            if (ack) {
                // 如果confirm返回成功，则进行更新
                BrokerMessageLogPO messageLogPO = new BrokerMessageLogPO();
                messageLogPO.setMessageId(messageId);
                messageLogPO.setStatus(Constants.OrderSendStatus.SEND_SUCCESS);
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLogPO);
            } else {
                // 失败则进行具体的后续操作：重试或者补偿等
                log.info("异常处理...");
            }
        }
    };

    /**
     * 发送订单
     *
     * @param order 订单
     */
    public void send(Order order) {
        // 设置回调方法
        rabbitTemplate.setConfirmCallback(confirmCallback);
        // 消息ID
        CorrelationData correlationData = new CorrelationData(order.getMessageId());
        // 发送消息
        rabbitTemplate.convertAndSend("order-exchange", "order.a", order, correlationData);
    }
}
