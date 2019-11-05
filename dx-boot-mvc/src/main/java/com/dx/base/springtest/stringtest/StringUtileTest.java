package com.dx.base.springtest.stringtest;

import org.springframework.util.StringUtils;

/**
 * Description: com.dx.base.springtest
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/5
 */
public class StringUtileTest {

    public static void main(String[] args) {


        System.out.println(StringUtils.isEmpty("ok"));


        System.out.println(StringUtils.isEmpty("  "));


        System.out.println(StringUtils.isEmpty(""));

        System.out.println(StringUtils.isEmpty(null));

        System.out.println("-----------------------------------------");

        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty("ok"));

        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty("  ".trim()));

        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty(""));

        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty(null));




    }


}
