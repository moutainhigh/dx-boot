package shiro.test;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.junit.Test;

/**
 * Description: shiro.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/28
 */
public class DefaultPasswordServiceTest {

    @Test
    public void test01(){

        DefaultPasswordService defaultPasswordService = new DefaultPasswordService();

        String s = defaultPasswordService.encryptPassword("123456");


        System.out.println(s);

    }


    @Test
    public void test02(){

        UsernamePasswordToken token = new UsernamePasswordToken("tom","123456");

        SimpleCredentialsMatcher doCredentialsMatch = new SimpleCredentialsMatcher();


        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("tom", "123456", "");


        boolean b = doCredentialsMatch.doCredentialsMatch(token, authenticationInfo);

        System.out.println(b);


    }


}
