package shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

/**
 * Description: shiro.realm
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/28
 */
public class MyCredentialsMatcher implements CredentialsMatcher{

    //设置密码加密
    private PasswordService passwordService = new DefaultPasswordService();

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        String password01 = passwordService.encryptPassword(new String((char[])token.getCredentials()));

        String password02 = new String((char[])info.getCredentials());

        return password01.equals(password02);
    }

}
