package com.dx.base.lambdaoptional;

import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Description: com.dx.optional
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/21
 */
public class Test01 {

    public static void main(String[] args) {
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//// 如果不是null,调用Consumer
//        optional1.ifPresent(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer t) {
//                System.out.println("value is " + t);
//            }
//        });
//
//
//
//// null,不调用Consumer
//        optional2.ifPresent(t -> {
//            System.out.println("result is  " + t);
//            System.out.println("value is " + t);
//        });
//
//        optional2.ifPresent(t -> {
//            System.out.println("result is  " + t);
//            System.out.println("value is " + t);
//        });


//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//// orElse
//        System.out.println(optional1.orElse(1000));// true
//        System.out.println(optional2.orElse(1000));// true


//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//        System.out.println(optional1.orElseGet(() -> {
//            return 1000;
//        }) == 1);//true
//
//        System.out.println(optional2.orElseGet(() -> {
//            return 1000;
//        }) == 1000);//true


//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//        optional1.orElseThrow(() -> {
//            throw new IllegalStateException();
//        });
//
//        try {
//            // 抛出异常
//            optional2.orElseThrow(() -> {
//                throw new IllegalStateException();
//            });
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }


//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//        Optional<Integer> filter1 = optional1.filter((a) -> a == null);
//        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);
//        Optional<Integer> filter3 = optional2.filter((a) -> a == null);
//        System.out.println(filter1.isPresent());// false
//        System.out.println(filter2.isPresent());// true
//        System.out.println(filter2.get().intValue() == 1);// true
//        System.out.println(filter3.isPresent());// false


//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
//        Optional<String> str2Optional = optional2.map((a) -> "key" + a);
//
//        System.out.println(str1Optional.get());// key1
//        System.out.println(str2Optional.isPresent());// false

//        Optional<Integer> optional1 = Optional.ofNullable(1);
//
//        Optional<Optional<String>> str1Optional = optional1.map((a) -> {
//            return Optional.<String>of("key" + a);
//        });
//
//        Optional<String> str2Optional = optional1.flatMap((a) -> {
//            return Optional.<String>of("key" + a);
//        });
//
//        System.out.println(str1Optional.get().get());// key1
//        System.out.println(str2Optional.get());// key1


//        String userName = "";
//
//        Optional<String> userName1 = Optional.of(userName);
//
//
//
//        String noUser = Optional.ofNullable(userName).map(t -> t).orElse("noUser");
//
//        System.out.println(noUser);

//        Teacher teacher1 = new Teacher("1", 1);
//        teacher1.setAge(22);
//
//        School school = new School();
//        school.setTeacher(teacher1);
//
//
//        Integer age = Optional.ofNullable(school).map(school1 -> school.getTeacher()).map(teacher -> teacher.getAge()).orElse(20);
//        System.out.println(age);
//
//
//        List<String> objects = Collections.emptyList();
//
//        List<String> strings = Arrays.asList(new String());
//
//        ArrayList<Teacher> teacherList = Lists.newArrayList(
//                new Teacher("1", 1),
//                new Teacher("2", 3));
//
//        class MyConsumer implements Consumer<Object>{
//
//            @Override
//            public void accept(Object t) {
//                System.out.println("打印输出(动作执行的参数)：" + t);
//            }
//
//        }
//
//        teacherList.forEach(new MyConsumer());


//        List<String> list = new ArrayList<String>();
//        list.add("aaa1");
//        list.add("bbb1");
//        list.add("ccc1");
//        list.add("aaa2");
//        String message = list.stream()
//                .filter(record -> record.startsWith("aaa"))
//                .map(record ->{
//                    return "<"+record+">";
//                })
//                .collect(Collectors.joining(","));//返回一个String以,分隔
//        //.collect(Collectors.toList());//返回一个List<String>
//        System.out.println(message);


        List<Teacher> teacherList = Lists.newArrayList(
                new Teacher("tom", 22),
                new Teacher("jack", 23),
                new Teacher("miller", 21),
                new Teacher("smith", 18),
                new Teacher("mic", 19));


        List<Teacher> collect = teacherList.stream().filter(teacher -> {

            Optional.ofNullable(teacher.getScore()).orElse(3);

            teacher.setName("  姓名：" + teacher.getName());

            teacher.setScore(teacher.getScore() + 2);

            //return teacher.getAge() > 20 && teacher.getName().length() > 3;

            return true;
        }).collect(Collectors.toList());
        collect.forEach(teacher -> System.out.println(teacher));


        School school = new School();
        school.setSchoolName("湖南文理学院");
        Teacher teacher = new Teacher("梅小勇", 45);
        school.setTeacher(teacher);

        School school1 = new School();

        BeanUtils.copyProperties(school, school1, "ok");

        System.out.println(school1);


    }

}


@Data
class School {

    private String schoolName;

    private Teacher teacher;

}

@Data
class Teacher {
    private String name;

    private Integer age;

    private int score;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
