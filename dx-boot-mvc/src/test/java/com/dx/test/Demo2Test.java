package com.dx.test;


import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/23
 */
public class Demo2Test {

    @Test
    public void testMd5() throws Exception {
        String sal = "1";
        String str = "123" + sal;
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(md5);
    }

}
