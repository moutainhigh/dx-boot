package com.dx.security.service;

import com.dx.security.bean.User;
import com.dx.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/18
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getCustomersByPage(Pageable pageable) {
        return (List<User>) userRepository.findAll(pageable).getContent();
    }
}
