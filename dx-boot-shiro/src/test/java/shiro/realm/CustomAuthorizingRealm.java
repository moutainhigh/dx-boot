package shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: com.dx.shiro.test.realm
 *
 *          自定义的Authorizingrealm
 *          这个realm既有认证又有鉴权
 *
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/25
 */
public class CustomAuthorizingRealm extends AuthorizingRealm {

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

    /**
     * 2：授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        // 通过用户名获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        // 通过用户名获取权限数据
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }


//---------------------------------------方法-----------------------------------------------//

    /**
     *
     * 获取用户的权限数据
     * （模拟从数据库或缓存中获取权限数据）
     *
     * @param userName 用户名
     * @return 权限数据
     */
    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> permissions = new HashSet<String>();
        permissions.add("user:delete");
        permissions.add("user:add");
        return permissions;
    }


    /**
     * 获取用户的角色数据
     * （模拟从数据库或缓存中获取角色数据）
     *
     * @param userName 用户名
     * @return 角色数据
     */
    private Set<String> getRolesByUserName(String userName) {
        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }


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


    /**
     * 主函数用来测试
     * @param args
     */
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "tom");
        System.out.println(md5Hash.toString());
    }

}
