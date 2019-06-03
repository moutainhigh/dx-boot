package com.dx.test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: 清单 26. partitioningBy 按照未成年人和成年人归组
 *      在使用条件“年龄小于18”进行分组后可以看到，不到18岁的未成年人是一组，成年人是另外一组。
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class AdultPartition {
    public static void main(String[] args) {
        AdultPartition adultPartition = new AdultPartition();
        Map<Boolean, List<User>> children = Stream.generate(adultPartition.new UserSupplier())
                .limit(100)
                .collect(Collectors.partitioningBy(p -> p.age > 18));
        System.out.println("Children number:" + children.get(false).size());
        System.out.println("Adult number:" + children.get(true).size());

        Map<Boolean, List<User>> collect = children.get(false).stream().collect(Collectors.partitioningBy(p -> p.age < 10));

        System.out.println("Children      <  10            number:" + collect.get(false).size());




    }

    class UserSupplier implements Supplier<User> {
        private int index = 0;
        private final Random random = new Random();
        @Override
        public User get() {
            return new User(index++, "name_" + index, random.nextInt(100));
        }
    }
    class User {
        public int no;
        public String name;
        public int age;
        public User(int no, String name, int age) { this.no = no;  this.name = name;  this.age = age; }
    }
}
