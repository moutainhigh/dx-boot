package com.dx.mapper;

import com.dx.bean.User;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/17
 */
public interface UserMapper {

    User findByUsername(String username);

    User findUserById(String Id);
}
