package shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.shiro.test.realm
 *
 *          自定义的Authenticatingrealm
 *          这个realm只有认证的作用（判断用户是否存在）
 *
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/25
 */
public class CustomAuthenticatingRealm extends AuthenticatingRealm {

    Map<String, String> userMap = new HashMap<String, String>();
    {
        userMap.put("tom", "f19b50d5e3433e65e6879d0e66632664");
        //super.setName("customRealm");
    }


    /**
     * 1：认证
     * @param token 主体传送过来的认证信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String userName = (String) token.getPrincipal();
        // 通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, "");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        return authenticationInfo;
    }



    //---------------------------------------方法-----------------------------------------------//


    /**
     * 获取用户密码
     * （模拟数据库查询凭证）
     *
     * @param userName 用户名
     * @return 凭证
     */
    private String getPasswordByUserName(String userName) {
        // 实际开发中需访问数据库
        return userMap.get(userName);
    }






}
