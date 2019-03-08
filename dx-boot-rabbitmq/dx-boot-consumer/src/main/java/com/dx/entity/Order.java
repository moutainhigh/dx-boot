package com.dx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <br>
 * 标题: 订单实体<br>
 * 描述: 订单实体<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Data
public class Order implements Serializable{

    private String id;

    private String name;
    /**
     * 存储消息发送的唯一标识
     */
    private String messageId;

}
