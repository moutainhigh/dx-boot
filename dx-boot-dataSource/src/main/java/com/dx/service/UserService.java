package com.dx.service;

import com.dx.bean.User;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/4
 */
public interface UserService {

    User findByEmail(String email);

    User save(User user);

}
