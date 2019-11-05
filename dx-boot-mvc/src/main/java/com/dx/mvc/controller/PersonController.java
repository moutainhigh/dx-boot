package com.dx.mvc.controller;

import com.dx.mvc.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/22
 */
@RestController
public class PersonController {


    @GetMapping("/getPerson")
    public Object getPerson(){

        List<Person> personList = new ArrayList<>();

        Person person1 = new Person("1","1","1");
        Person person2 = new Person("2","2","2");
        Person person3 = new Person("3","3","3");
        Person person4 = new Person("4","1","1");
        Person person5 = new Person("5","1","1");
        Person person6 = new Person("6","1","1");
        Person person7 = new Person("7","1","1");
        Person person8 = new Person("8","1","1");
        Person person9 = new Person("9","1","1");
        Person person10 = new Person("10","1","1");
        Person person11 = new Person("11","1","1");


        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);
        personList.add(person9);
        personList.add(person10);
        personList.add(person11);



        return personList;
    }

}
