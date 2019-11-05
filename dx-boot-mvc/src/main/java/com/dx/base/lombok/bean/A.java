package com.dx.base.lombok.bean;

import lombok.Data;

/**
 * Description: com.dx.lombok.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/29
 */
@Data
public class A {

    private String id;
    private String name;

    public A() {
        System.out.println("无参数构造A");
    }
}
