package com.dx.security.bean;

import cn.wanghaomiao.seimi.annotation.Xpath;
import lombok.Data;

import java.util.List;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-7
 */
@Data
public class Href {

    @Xpath("//a//@href")
    private List<String> link;

    @Xpath("//a//@id")
    private List<String> id;

    @Xpath("//a/text()")
    private List<String> countent;

    @Xpath("//a")
    private List<String> aTag;




}
