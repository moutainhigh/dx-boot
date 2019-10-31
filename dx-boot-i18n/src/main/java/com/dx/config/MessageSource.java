package com.dx.config;

import com.dx.service.QueryI18nDataService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;

/**
 * Description: com.dx.config
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/30
 */

public class MessageSource extends AbstractMessageSource implements ResourceLoaderAware, InitializingBean {


    private Logger logger = LoggerFactory.getLogger(getClass());

    //map切分字符
    protected final String MAP_SPLIT_CODE = "|";

    @SuppressWarnings("unused")
    private ResourceLoader resourceLoader;

    @Autowired
    private QueryI18nDataService queryI18nDataService;
    /**
     * 存放所有国际化数据
     */
    private final Map<String, String> dataMap = Maps.newHashMap();

    public MessageSource() {


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        dataMap.clear();
        dataMap.putAll(LoadDesc());
    }


    private Map<String, String> LoadDesc() {
        List<BKwLanguage> languages = Lists.newArrayList();
        Map<String, String> mapResource = Maps.newHashMap();

        logger.info("开始查询国际化数据");
        languages = queryI18nDataService.queryData();
        for (BKwLanguage bKwLanguage : languages) {
            String code = bKwLanguage.getKeyword() + MAP_SPLIT_CODE + bKwLanguage.getLanguage();
            mapResource.put(code, bKwLanguage.getInternationalContent());
        }
        return mapResource;
    }




    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader != null?resourceLoader : new DefaultResourceLoader();
    }


    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = getText(code, locale);
        MessageFormat result = createMessageFormat(msg, locale);
        return result;
    }


    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        String result = getText(code, locale);
        return result;
    }


    private String getText(String code, Locale locale){

        String localeCode = locale.getLanguage();
        //本地语言编码
        String key = code + MAP_SPLIT_CODE + localeCode;

        String localeText = dataMap.get(key);

        String resourceText =code;

        if(localeText != null){
            resourceText = localeText;
        }else{
            localeCode = Locale.CHINESE.getLanguage();
            key = code + MAP_SPLIT_CODE + localeCode;
            localeText = dataMap.get(key);
            if(localeText != null){
                resourceText = localeText;
            }else{
                try {
                    if(getParentMessageSource() != null){
                        resourceText = getParentMessageSource().getMessage(code, null, locale);
                    }
                } catch (Exception e) {
                    logger.error("Con not find message with code:", code, e.getMessage());
                }
            }
        }

        return resourceText;
    }

}

