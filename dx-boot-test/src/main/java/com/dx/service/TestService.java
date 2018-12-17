package com.dx.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-11
 */
@Service
public class TestService {

    public String test() {
        String s = "  ";
        Assert.hasLength(s, " 不能问空  ");
        return "";
    }


}
