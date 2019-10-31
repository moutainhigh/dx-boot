package com.dx.controller;

import cn.hutool.core.util.StrUtil;
import com.dx.bean.OssSetting;
import com.dx.bean.SettingConstant;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/28
 */
public class SettingController {

    @RequestMapping(value = "/oss/set", method = RequestMethod.POST)
    //@ApiOperation(value = "OSS配置")
    public Result<Object> ossSet(@ModelAttribute OssSetting ossSetting) {
        if (ossSetting.getServiceName().equals(SettingConstant.QINIU_OSS)) {
            // 七牛
            String v = redisTemplate.opsForValue().get(SettingConstant.QINIU_OSS);
            if (StrUtil.isNotBlank(v) && !ossSetting.getChanged()) {
                String secrectKey = new Gson().fromJson(v, OssSetting.class).getSecretKey();
                ossSetting.setSecretKey(secrectKey);
            }
            redisTemplate.opsForValue().set(SettingConstant.QINIU_OSS, new Gson().toJson(ossSetting));
            redisTemplate.opsForValue().set(SettingConstant.OSS_USED, SettingConstant.QINIU_OSS);
        } else if (ossSetting.getServiceName().equals(SettingConstant.ALI_OSS)) {
            // 阿里
            String v = redisTemplate.opsForValue().get(SettingConstant.ALI_OSS);
            if (StrUtil.isNotBlank(v) && !ossSetting.getChanged()) {
                String secrectKey = new Gson().fromJson(v, OssSetting.class).getSecretKey();
                ossSetting.setSecretKey(secrectKey);
            }
            redisTemplate.opsForValue().set(SettingConstant.ALI_OSS, new Gson().toJson(ossSetting));
            redisTemplate.opsForValue().set(SettingConstant.OSS_USED, SettingConstant.ALI_OSS);
        } else if (ossSetting.getServiceName().equals(SettingConstant.TENCENT_OSS)) {
            // 腾讯
            String v = redisTemplate.opsForValue().get(SettingConstant.TENCENT_OSS);
            if (StrUtil.isNotBlank(v) && !ossSetting.getChanged()) {
                String secrectKey = new Gson().fromJson(v, OssSetting.class).getSecretKey();
                ossSetting.setSecretKey(secrectKey);
            }
            redisTemplate.opsForValue().set(SettingConstant.TENCENT_OSS, new Gson().toJson(ossSetting));
            redisTemplate.opsForValue().set(SettingConstant.OSS_USED, SettingConstant.TENCENT_OSS);
        } else if (ossSetting.getServiceName().equals(SettingConstant.LOCAL_OSS)) {
            // 本地
            redisTemplate.opsForValue().set(SettingConstant.LOCAL_OSS, new Gson().toJson(ossSetting));
            redisTemplate.opsForValue().set(SettingConstant.OSS_USED, SettingConstant.LOCAL_OSS);
        }
        return new ResultUtil<Object>().setData(null);
    }
}
