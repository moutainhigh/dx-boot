package com.dx.security.core.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * Description:模仿UsernamePasswordAuthenticationToken写的短信登录token
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    //没登陆，放手机号，登录成功，放用户信息
    private final Object principal;


    /**
     * 一个参数的构造，new的对象是没有认证的
     * 没登录principal放手机号
     * <p>Description: </p>
     *
     * @param mobile
     */
    public SmsCodeAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;//没登录放手机号
        setAuthenticated(false);//还没认证通过
    }

    /**
     * 2个参数的构造，new的对象是认证通过的
     * <p>Description: </p>
     *
     * @param principal
     * @param authorities
     */
    public SmsCodeAuthenticationToken(Object principal,
                                      Collection<? extends GrantedAuthority> authorities) {
        super(authorities); //authorities放用户权限
        this.principal = principal; //放用户信息
        super.setAuthenticated(true); //认证通过
    }

    // ~ Methods
    // ========================================================================================================


    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}




