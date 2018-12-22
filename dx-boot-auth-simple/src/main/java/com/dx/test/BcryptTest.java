package com.dx.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-20
 */
public class BcryptTest {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode("123");
        System.out.println("    encode1   " + encode1);
        String encode2 = bCryptPasswordEncoder.encode("123");
        System.out.println("    encode2   " + encode2);

        System.out.println("is eques : "   +  encode1.equals(encode2));

        System.out.println(" use spring bcrypt  is eques : "   + bCryptPasswordEncoder.matches("123",encode2));



    }


}
