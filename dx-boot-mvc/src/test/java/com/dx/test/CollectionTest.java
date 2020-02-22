package com.dx.test;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/2/5
 */
public class CollectionTest {


    @Test
    public void mapTest() {

        Map map = new HashMap<>();
        map.put("num1",123L);


        Integer integer = MapUtils.getInteger(map, "num1");

        System.out.println(integer);


    }

}
