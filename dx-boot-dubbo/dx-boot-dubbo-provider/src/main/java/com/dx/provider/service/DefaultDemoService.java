package com.dx.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dx.api.DemoService;
import org.springframework.beans.factory.annotation.Value;

/**
 * Description: com.dx.api.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/25
 */
@Service(interfaceClass=DemoService.class,version = "1.0",timeout=10000)
public class DefaultDemoService implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
