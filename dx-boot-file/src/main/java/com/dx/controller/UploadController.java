package com.dx.controller;

import ch.qos.logback.core.util.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.dx.bean.SettingConstant;
import com.dx.util.AliOssUtil;
import com.dx.util.QiniuUtil;
import com.dx.util.TencentOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/28
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private QiniuUtil qiniuUtil;
    @Autowired
    private AliOssUtil aliOssUtil;
    @Autowired
    private TencentOssUtil tencentOssUtil;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public Result<Object> upload(@RequestParam(required = false) MultipartFile file,
                                 @RequestParam(required = false) String base64,
                                 HttpServletRequest request) {
        String used = redisTemplate.opsForValue().get(SettingConstant.OSS_USED);
        if (StrUtil.isBlank(used)) {
            return new ResultUtil<Object>().setErrorMsg(501, "您还未配置OSS服务");
        }
        if (StrUtil.isNotBlank(base64)) {
            // base64上传
            file = Base64DecodeMultipartFile.base64Convert(base64);
        }
        String result = "";
        //重命名文件，UUID+后缀
        String fKey = CommonUtil.renamePic(file.getOriginalFilename());
        File f = new File();
        try {
            InputStream inputStream = file.getInputStream();
            // 上传至第三方云服务或服务器
            if (used.equals(SettingConstant.QINIU_OSS)) {
                //七牛云上传
                result = qiniuUtil.qiniuInputStreamUpload(inputStream, fKey);
                f.setLocation(CommonConstant.OSS_QINIU);
            } else if (used.equals(SettingConstant.ALI_OSS)) {
                //阿里云上传
                result = aliOssUtil.aliInputStreamUpload(inputStream, fKey);
                f.setLocation(CommonConstant.OSS_ALI);
            } else if (used.equals(SettingConstant.TENCENT_OSS)) {
                //腾讯云上传
                result = tencentOssUtil.tencentInputStreamUpload(file, inputStream, fKey);
                f.setLocation(CommonConstant.OSS_TENCENT);
            } else if (used.equals(SettingConstant.LOCAL_OSS)) {
                //本地上传
                result = fileUtil.localUpload(file, fKey);
                f.setLocation(CommonConstant.OSS_LOCAL);
            }
            // 文件信息保存数据信息至数据库
            //略
        } catch (Exception e) {
            log.error(e.toString());
            return new ResultUtil<Object>().setErrorMsg(e.toString());
        }
        return new ResultUtil<Object>().setData(result);
    }
}
