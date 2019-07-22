package com.dx.service;

import com.dx.bean.User;
import com.dx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/4
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        //return userRepository.findByEmail(email);
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
