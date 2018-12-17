package com.dx.regist.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * Description:服务断开监听
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-05
 */
@Configuration
@Slf4j
public class InstanceCancelListener implements ApplicationListener<EurekaInstanceCanceledEvent> {

    @Override
    public void onApplicationEvent(EurekaInstanceCanceledEvent event) {
        log.info("服务:{}挂了", event.getAppName());
    }

}
