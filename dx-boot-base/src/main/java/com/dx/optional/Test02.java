package com.dx.optional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Description: com.dx.optional
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class Test02 {


    public static void main(String[] args) {

        int a[] = {1,2,5,2,7,1,9,3,0};

        OptionalInt min = IntStream.of(a).parallel().min();


        System.out.println(min);

        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

        String format = new DecimalFormat("#.###").format(20000);


        System.out.println(format);


        Dog dog = new Dog();
        Function<String, String> say = dog::say;


        System.out.println(say.apply("你好"));


        Supplier supplier = Dog::new;

        System.out.println(supplier.get());


        Test02 test02 = new Test02();
        ArrayList<String> strings = new ArrayList<>();

        test02.getList(strings);
        System.err.println(strings);


    }

    public List getList(List list){
        list = null;
        return list;
    }


}


class Dog{

    public String say(String str){

        return "say  :  " + str;
    }


}

