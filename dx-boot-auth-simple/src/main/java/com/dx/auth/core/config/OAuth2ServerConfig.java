package com.dx.auth.core.config;

import com.dx.security.core.properties.SecurityProperties;
import com.dx.security.core.validate.code.SmsCodeFilter;
import com.dx.security.core.validate.code.ValidateCodeFilter;
import com.dx.security.core.validate.code.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 认证服务器
 * 提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-23
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * token存在redis，默认是在内存
     */
    @Autowired
    private TokenStore tokenStore;

    /**
     * jwt需要的两个增强器之一：将uuid转换为jwt
     * 有jwt配置时才生效
     */
    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * jwt需要的两个增强器之二：往jwt添加自定义信息
     */
    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;

    /**
     * 配置TokenEndpoint 是  /oauth/token处理的入口点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);

        /**
         * 使用JWT ，有两个增强器：
         * 	1，使用JwtAccessTokenConverter将uuid的token转为jwt，用秘钥签名
         *  2，由于默认生成uuid token的方法是private，所以通过ImoocJwtTokenEnhancer 往jwt里添加一些自定义的信息
         *
         *  在这里拿到增强器的链，把这两个增强器连起来
         */
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            //拿到增强器链
            TokenEnhancerChain enhancerChain = new TokenEnhancerChain();

            List<TokenEnhancer> enhancers = new ArrayList<TokenEnhancer>();
            enhancers.add(jwtAccessTokenConverter);
            enhancers.add(jwtTokenEnhancer);

            enhancerChain.setTokenEnhancers(enhancers);

            endpoints.tokenEnhancer(enhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    /**
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .realm("oauth2-resources")
                //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                .tokenKeyAccess("permitAll()")
                //url:/oauth/check_token allow check token
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    /**
     * 功能：认证服务器会给哪些第三方应用发令牌
     * 覆盖了该方法，application.properties里配置的
     * security.oauth2.client.clientId = imooc
     * security.oauth2.client.clientSecret = imoocsecret
     * 就失效了
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //实现需要认证的接口跳转表单登录,安全=认证+授权
        clients
                .inMemory()
                .withClient("demoApp")
                .secret(bCryptPasswordEncoder.encode("demoAppSecret"))
                //.secret("{noop}demoAppSecret")
                //.secret("demoAppSecret")
                .redirectUris("http://baidu.com")
                //这些也可以配置也可以写死，看心情
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token",
                        "password", "implicit")
                .scopes("all")
                .resourceIds("oauth2-resource")
                //refresh_token 有效期 可以长些
                .accessTokenValiditySeconds(12000)
                .refreshTokenValiditySeconds(50000);
    }
}
