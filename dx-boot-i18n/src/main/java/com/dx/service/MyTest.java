package com.dx.server.service;

import com.dx.config.I18nMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/30
 */
@Service
public class MyTest {

    @Autowired
    private I18nMessageSource i18nMessageSource;

    public void say(){

        i18nMessageSource.clearCache();
    }

}
