package shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * description
 *
 *
 *     完整的认证、鉴权的过程
 *
 *
 *
 * @author rockstarsteve
 * @date 2019/09/25
 */
public class IniRealmTest {

    @Test
    public void  testAuthentication(){

        // 使用IniRealm
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark","123456");
        subject.login(token);



        //-----------------------------认证、鉴权----------------------------------------//

        //鉴用户user
        System.out.println("isAuthenticated:" + subject.isAuthenticated());
        //鉴角色role
        subject.checkRole("admin");
        //鉴权限permission
        subject.checkPermission("user:delete");
        subject.checkPermission("user:update");
    }

}
