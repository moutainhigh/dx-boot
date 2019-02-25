package com.dx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-24
 */
@Data
public class Order implements Serializable {

    /**
     * 订单id
     */
    private String id;

    /**
     * 订单名称
     */
    private String name;

    /**
     * 消息id
     */
    private String messageId;

}
