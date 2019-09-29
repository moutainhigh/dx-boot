package shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import shiro.realm.CustomAuthenticatingRealm;
import shiro.realm.MyCredentialsMatcher;

/**
 * description
 *
 *      使用自定义的realm
 *      仅认证色过程
 *
 *
 *
 *
 * @author rockstarsteve
 * @date 2019/09/25
 */
public class CustomAuthenticatingRealmTest {

    CredentialsMatcher credentialsMatcher;

    @Before
    public void befor(){
        credentialsMatcher = new MyCredentialsMatcher();
    }


    @Test
    public void  testAuthentication(){
        CustomAuthenticatingRealm customRealm = new CustomAuthenticatingRealm();

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


        //构建加密类
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

//        customRealm.setCredentialsMatcher(credentialsMatcher);

        defaultSecurityManager.setRealm(customRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("tom","123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());


        //退出
        subject.logout();
    }
}
