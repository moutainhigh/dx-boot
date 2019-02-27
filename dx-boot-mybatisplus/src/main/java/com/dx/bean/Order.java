package com.dx.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-2-27
 */
@Data
@Accessors(chain = false)
public class Order {

    @Setter(value = AccessLevel.NONE)
    private String id;

}
