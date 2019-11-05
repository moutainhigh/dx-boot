package com.dx.mvc.bean;

import lombok.Data;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/22
 */
@Data
public class Person {

    private String id;

    private String name;

    private String price;

    public Person(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
