package com.dx.config;

import com.dx.service.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;

@Service
public class I18nMessageSource extends ReloadableResourceBundleMessageSource {

    @Autowired
    private MyTest myTest;

    public I18nMessageSource() {
        this.setDefaultEncoding("UTF-8");
        this.setBasenames("classpath:/i18n/core/common/i18n","classpath:/i18n/core/common_view/i18n","classpath:/i18n/core/sys/i18n");
        this.setCacheSeconds(60);
    }


    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        return super.resolveCode(code, locale);
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        return super.resolveCodeWithoutArguments(code, locale);
    }

    @Override
    public void clearCache() {
        super.clearCache();
    }
}
