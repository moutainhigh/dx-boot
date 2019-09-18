package com.dx.controller;

import com.dx.bean.User;
import com.dx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/18
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    public List<User> getCustomersByPage() {
        int page = 0, size =3;
        Sort sort = new Sort(Sort.Direction.DESC, "age");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userService.getCustomersByPage(pageable);
    }

}
