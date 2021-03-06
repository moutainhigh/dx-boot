package com.dx.mvc.controller;

import com.dx.mvc.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/22
 */
@RestController
@RequestMapping("/vue")
public class VueController {


    @RequestMapping("/getData")
    public Object getData() {


        ArrayList<User> userArrayList = new ArrayList<>();

        userArrayList.add(new User("tom", "tom001", "湖南",new Date()));
        userArrayList.add(new User("tom2", "tom002", "湖北",new Date()));
        userArrayList.add(new User("tom", "tom001", "湖南",new Date()));
        userArrayList.add(new User("tom2", "tom002", "湖北",new Date()));

        return userArrayList;

    }

}
