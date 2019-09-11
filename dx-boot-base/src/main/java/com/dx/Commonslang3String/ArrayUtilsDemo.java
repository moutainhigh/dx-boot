package com.dx.Commonslang3String;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * Description: com.dx.Commonslang3String
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/28
 */
public class ArrayUtilsDemo {

    public static void main(String[] args) {

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("ok");

//        boolean notEmpty = ArrayUtils.isNotEmpty(stringArrayList);
//        System.out.println(notEmpty);

        boolean empty = CollectionUtils.isEmpty(stringArrayList);
        System.out.println(empty);
    }

}
