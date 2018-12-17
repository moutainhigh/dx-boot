package com.dx.security.core.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 验证码
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;//过期时间点


    /**
     *
     * <p>Description: </p>
     * @param image
     * @param code
     * @param expireTn 多少秒过期
     */
    public ImageCode(BufferedImage image, String code, int expireTn) {
        super();
        this.image = image;
        this.code = code;
        //过期时间=当前时间+过期秒数
        this.expireTime = LocalDateTime.now().plusSeconds(expireTn);
    }


    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super();
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 验证码是否过期
     * @Description: 验证码是否过期
     * @param @return  true 过期，false 没过期
     * @return boolean   true 过期，false 没过期
     * @throws
     * @author lihaoyang
     * @date 2018年3月2日
     */
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

}
