package com.dx.security.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dx.api.DemoService;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/26
 */
@Service
public class ServiceConsumer {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

}
