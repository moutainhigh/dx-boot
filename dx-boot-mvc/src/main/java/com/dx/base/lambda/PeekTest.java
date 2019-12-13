package com.dx.base.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.base.lambda
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/5
 */
public class PeekTest {


    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        User user = new User("tom",1);
        User user2 = new User("jack",2);
        list.add(user);
        list.add(user2);

//        List<String> collect = list.stream().map(users -> users.getName).collect(Collectors.toList());



        list.stream().forEach(user1 -> user1.setAge(user1.getAge()+20));
        list.stream().forEach(str -> System.out.println(str));

    }



}


@Data
@AllArgsConstructor
class User {
   String name;
   int age;
}

