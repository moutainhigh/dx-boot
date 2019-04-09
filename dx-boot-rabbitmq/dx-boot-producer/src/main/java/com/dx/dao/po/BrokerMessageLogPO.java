package com.dx.dao.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * 标题: 消息日志<br>
 * 描述: 消息日志<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Data
//@TableName("broker_message_log")
public class BrokerMessageLogPO implements Serializable {

    /**
     * 消息ID
     */
    private String messageId;
    /**
     * 消息内容
     */
    private String message;
    /**
     * '重试次数'
     */
    private Integer tryCount;
    /**
     * 投递状态 {@code com.myimooc.rabbitmq.ha.constant.Constants.OrderSendStatus}
     */
    private String status;
    /**
     * 下次重试时间
     */
    private Date nextRetry;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}