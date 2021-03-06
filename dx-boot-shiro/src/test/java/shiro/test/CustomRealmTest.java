package shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import shiro.realm.CustomRealm;

/**
 * description
 *
 *      使用自定义的realm
 *      完整的认证过程(判断用户是否存在)
 *
 *
 *
 *
 * @author rockstarsteve
 * @date 2019/09/25
 */
public class CustomRealmTest {

    @Test
    public void  testAuthentication(){
        CustomRealm customRealm = new CustomRealm();

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

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
