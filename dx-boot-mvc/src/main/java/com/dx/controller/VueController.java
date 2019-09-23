package com.dx.controller;

import com.dx.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/22
 */
@RestController
public class VueController {


    @RequestMapping("/getData")
    public Object getData(){


        ArrayList<User> userArrayList = new ArrayList<>();

        userArrayList.add(new User("tom","tom001"));

        return userArrayList;

    }

}
