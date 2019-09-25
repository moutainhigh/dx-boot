package shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * description
 *
 *      使用SimpleAccountRealm
 *      认证、鉴角色过程
 *
 * @author rockstarsteve
 * @date 2019/09/25
 */
public class SimpleAccountRealmTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    /**
     * 使用临时的内存的用户角色权限
     */
    @Before
    public void init(){
        simpleAccountRealm.addAccount("Mark","123456","admin","user");
    }

    @Test
    public void  testAuthentication(){
        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark","123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        // 检查用户是否具有某个角色
        subject.checkRole("admin");
        // 可以同时检查多个角色
        subject.checkRoles("admin","user");

    }
}
