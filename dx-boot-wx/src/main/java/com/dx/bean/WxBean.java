package com.dx.bean;

import lombok.Data;

/**
 * Description: com.dx
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/9
 */
@Data
public class WxBean {

    private String access_token;

    private String expires_in;

    private String refresh_token;

    private String openid;

    private String scope;

}
