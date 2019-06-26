package com.dx.controller;

import com.dx.service.ServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/25
 */
@RestController
public class DemoController {


    @Autowired
    private ServiceConsumer serviceConsumer;

    @RequestMapping("/index")
    public String greeting() {
        return serviceConsumer.sayHello("tom  ----- 》");
    }

}
