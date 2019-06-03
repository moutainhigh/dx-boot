package com.dx.test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Description: 清单 23. 自实现Supplier 【Stream.generate 还接受自己实现的Supplier。
 *      例如在构造海量测试数据的时候，用某种自动的规则给每一个变量赋值，
 *      或者依据公式计算Stream的每个元素之。这些都是维持状态信息的情形】
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class SupplierTest {
    public static void main(String[] args) {
        SupplierTest supplierTest = new SupplierTest();
        Stream.generate(supplierTest.new UserSupplier()).limit(10)
                .forEach(p -> System.out.println(p.name + ":" + p.age));
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
        private final String name;
        private final int age;

        public User(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }
    }
}
