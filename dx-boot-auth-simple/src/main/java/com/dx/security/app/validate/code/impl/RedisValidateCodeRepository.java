package com.dx.security.app.validate.code.impl;

import com.dx.security.core.exception.ValidateCodeException;
import com.dx.security.core.validate.code.ValidateCode;
import com.dx.security.core.validate.code.ValidateCodeRepository;
import com.dx.security.core.validate.code.ValidateCodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * Description:redis验证码存取策略
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        String key = buildKey(request, validateCodeType);
        logger.info("--------->redis存进去了一个新的key：" + key + "，value：" + code + "<-----------");
        redisTemplate.opsForValue().set(key, code, 30, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, validateCodeType));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        String key = buildKey(request, validateCodeType);
        logger.info("--------->redis删除了一个key：" + key + "<-----------");
        redisTemplate.delete(key);
    }

    /**
     * 构建验证码在redis中的key
     *
     * @param @return
     * @return String  验证码在redis中的key
     * @throws
     * @Description: 构建验证码在redis中的key
     * @author lihaoyang
     * @date 2018年3月14日
     */
    private String buildKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
        //获取设备id
        String deviceId = request.getHeader("deviceId");
        if (deviceId == null) {
            throw new ValidateCodeException("deviceId为空，请求头中未携带deviceId参数");
        }
        return "code:" + validateCodeType.toString().toLowerCase() + ":" + deviceId;
    }


}
