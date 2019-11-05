package com.dx.base.lambdaoptional;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Description: com.dx.optional
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/19
 */
public class Demo01 {

    public static void main(String[] args) {

        List<Student> studentList = Lists.newArrayList(
                new Student(),
                new Student("mimller"),
                new Student("tom", 23),
                new Student("jack", 22, "湖南")
        );

        List<Student> collect = studentList.stream().filter(student -> {
            Optional.ofNullable(student.getAge()).orElse(20);


            Optional<Student> student1 = Optional.of(student);
            student.setAddress(student1.map(s -> s.getAddress())
                    .orElse("广东"));
//            student.setAge(student1.map(s -> s.getAge())
//                    .orElse(20));
            return student.getName() != null;
        }).collect(Collectors.toList());

        collect.forEach(student -> System.out.println(student));


        String s = StringUtils.defaultIfEmpty("   ", "you dongxi");
        System.out.println(s);


    }

}

@Data
class Student {

    private String name;

    private Integer age;

    private String address;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
