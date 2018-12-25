package com.dx.security.app.validate.code.impl;

import com.dx.security.core.exception.ValidateCodeException;
import com.dx.security.core.validate.core.ValidateCode;
import com.dx.security.core.validate.core.ValidateCodeRepository;
import com.dx.security.core.validate.core.ValidateCodeType;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * Description: 这个缓存只当测试使用，具体请使用RedisValidateCodeRepository这个类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-25
 */
@Component
public class GauvaCacheValidateCodeRepository implements ValidateCodeRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final Cache<String, Object> ObjectCache =
            CacheBuilder.newBuilder().maximumSize(3).expireAfterAccess(1, TimeUnit.MINUTES).build();

        @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        String key = buildKey(request, validateCodeType);
        logger.info("--------->redis存进去了一个新的key："+key+"，value："+code+"<-----------");
        ObjectCache.put(key,code);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        Object value =  ObjectCache.getIfPresent(buildKey(request, validateCodeType));
        if(value == null){
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        String key = buildKey(request, validateCodeType);
        logger.info("--------->redis删除了一个key："+key+"<-----------");
        ObjectCache.invalidate(key);
    }

    /**
     * 构建验证码在redis中的key
     * @Description: 构建验证码在redis中的key
     * @param @return
     * @return String  验证码在redis中的key
     * @throws
     * @author lihaoyang
     * @date 2018年3月14日
     */
    private String buildKey(ServletWebRequest request , ValidateCodeType validateCodeType){
        //获取设备id
        String deviceId = request.getHeader("deviceId");
        if(deviceId == null){
            throw new ValidateCodeException("deviceId为空，请求头中未携带deviceId参数");
        }
        return "code:" + validateCodeType.toString().toLowerCase()+":"+deviceId;
    }
}
