package com.dx.mapper;

import com.dx.bean.User;
import org.springframework.stereotype.Component;

/**
 * Description: com.dx.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/17
 */
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User findByUsername(String username) {
        if ("tom".equals(username)) {
            return new User("1", "tom", "123");
        }
        return null;
    }

    @Override
    public User findUserById(String id) {
        if ("1".equals(id)) {
            return new User("1", "tom", "123");
        }
        return null;
    }
}
