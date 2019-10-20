package com.dx.service;

import com.dx.bean.User;
import com.dx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/17
 */
@Service
public class UserService {


    @Autowired
    UserMapper userMapper;

    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }


}
