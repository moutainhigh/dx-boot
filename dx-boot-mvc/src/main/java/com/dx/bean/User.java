package com.dx.bean;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class User {

    private String name;

    private String nick;

    private String address;

}
