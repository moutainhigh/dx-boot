package com.dx.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.def.DefaultRedisQueue;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import com.dx.bean.Href;
import org.seimicrawler.xpath.JXDocument;

import java.util.List;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-7
 */
@Crawler(name = "MyTest")
public class MyTest extends BaseSeimiCrawler {
    @Override
    public String[] startUrls() {
        return new String[]{"https://www.baidu.com/"};
    }

    @Override
    public void start(Response response) {

        try {
            Href href = response.render(Href.class);
            logger.info("内容是：         -----------------》   "+href.toString());
        } catch (Exception e) {
            logger.info("解析错误");
            e.printStackTrace();
        }

    }
}
