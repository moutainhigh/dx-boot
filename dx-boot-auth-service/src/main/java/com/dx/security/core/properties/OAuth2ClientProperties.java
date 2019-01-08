package com.dx.security.core.properties;

import lombok.Data;

/**
 * Description:接口授权客户端配置
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    /**
     * toke有效时间
     */
    private int accessTokenValiditySeconds = 3600;

    /**
     * refreshToken有效时间
     */
    private int refreshTokenValiditySeconds = 50000;

}
