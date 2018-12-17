package com.dx.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-11
 */
public class TestServiceTest {

    @Test
    public void test1() {
        TestService testService = new TestService();
        String test = testService.test();
        System.out.println(test);

    }
}