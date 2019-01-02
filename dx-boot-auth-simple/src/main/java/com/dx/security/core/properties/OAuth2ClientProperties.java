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
     * 没配置就用默认值
     */
    private int accessTokenValiditySeconds = 3600;

}
