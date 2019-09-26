package shiro.test;

import shiro.realm.CustomAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * description
 *
 *      使用自定义的realm
 *      完整的认证、鉴角色过程
 *
 *
 *
 *
 * @author rockstarsteve
 * @date 2019/09/25
 */
public class CustomAuthorizingRealmTest {

    @Test
    public void  testAuthorizing(){
        CustomAuthorizingRealm customRealm = new CustomAuthorizingRealm();

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


        //构建加密类
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        customRealm.setCredentialsMatcher(matcher);

        defaultSecurityManager.setRealm(customRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("tom","123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        //是否鉴权
        System.out.println("isRemembered:" + subject.isRemembered());

        subject.checkRole("admin");
        subject.checkPermission("user:delete");
        subject.checkPermission("user:add");


        //退出
        subject.logout();
    }
}
