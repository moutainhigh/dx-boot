package com.dx.servcie;

import com.dx.security.bean.User;
import com.dx.util.AppData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Description: com.dx.servcie
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Service
public class UserService {

    @Autowired
    private AppData appData;

    /**
     * 获取用户
     * @param username
     * @return
     */
    public User get(String username){
        Object password = appData.getUserMap().get("username");
        if (!StringUtils.isEmpty(password)){
            return new User(username,(String)password);
        }
        return null;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName,String password){
        Object tempPassword = appData.getUserMap().get(userName);
        if (!StringUtils.isEmpty(tempPassword) && tempPassword.equals(password)){
            appData.getLoginMap().put(userName,userName);
            return new User(userName,null);
        }
        return null;
    }


    /**
     * 退出登录
     * @param username
     * @return
     */
    public boolean unLogin(String username){
        appData.getLoginMap().remove(username);
        return true;
    }

}
