package com.dx.base.Commonslang3String;

import org.apache.commons.lang3.StringUtils;

/**
 * Description: com.dx.Commonslang3String
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/28
 */
public class StringUtilDemo {

    public static void main(String[] args) {

        boolean equals = StringUtils.equals("", null);
        System.out.println(equals);


        boolean notBlank = StringUtils.isNotBlank(" ");
        System.out.println(notBlank);


        boolean empty = StringUtils.isEmpty(" ");
        System.out.println(empty);



    }

}
