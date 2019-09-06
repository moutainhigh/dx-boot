package com.dx.lambdatest;

import com.dx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        connection.close();
    }

    @Test
    public void testAdd(){
//        User user = new User();
//        user.setId(234L);
//        user.setUserName("yaojian");
//        user.setEmail("888444@qq.com");
//        User saveUser = userService.save(user);
//        System.out.println(saveUser);
//        System.out.println("-------------------------------");



    }





}
