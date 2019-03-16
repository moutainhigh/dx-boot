package com.dx.enumtest;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-15
 */
public enum  StatusEnum {

    UP(1),
    DOWN(-1);

    private int value;

    public int getValue() {
        return value;
    }

    StatusEnum(int value) {
        this.value = value;
    }
}
