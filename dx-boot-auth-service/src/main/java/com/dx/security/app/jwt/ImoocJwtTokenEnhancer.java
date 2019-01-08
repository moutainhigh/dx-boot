package com.dx.security.app.jwt;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: jwt增强器
 * 往jwt的 token增加自己的信息
 * spring默认生成token的方法在DefaultTokenService里，是private，生成的是uuid，没办法重写，只能是增强器把uuid转换成jwt，添加一些信息
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public class ImoocJwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //往jwt添加的自定义信息
        Map<String, Object> info = new HashMap<>();
        info.put("company", "dx");
        info.put("product_code", "100");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

}
