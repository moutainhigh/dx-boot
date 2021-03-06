package com.dx.security.service;

import org.springframework.security.core.userdetails.User;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
public interface UserService {

    User getByName(String username);
}
