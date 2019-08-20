package com.dx.commonslang3;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Description: com.dx.commonslang3
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/19
 */
public class RandomStringDemo {

    public static void main(String[] args) {

        // 第一个参数表示生成位数，第二个表示是否生成字母，第三个表示是否生成数字
        System.out.println(RandomStringUtils.random(15, true, false));

        // 长度、起始值、结束值、是否使用字母、是否生成数字
        System.out.println(RandomStringUtils.random(15, 5, 129, true, false));

        System.out.println(RandomStringUtils.random(22));

        // 从指定字符串随机生成
        System.out.println(RandomStringUtils.random(15, "abcdefgABCDEFG123456789"));

        // 从字母中抽取
        System.out.println(RandomStringUtils.randomAlphabetic(15));

        // 从数字抽取
        System.out.println(RandomStringUtils.randomNumeric(15));

        // ASCII between 32 and 126 =内部调用(random(count, 32, 127, false,false);)
        System.out.println(RandomStringUtils.randomAscii(15));

    }

}
