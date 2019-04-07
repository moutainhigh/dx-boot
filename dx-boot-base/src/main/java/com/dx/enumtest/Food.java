package com.dx.enumtest;

import java.util.AbstractSet;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-04-03
 */
public interface Food {
    final Integer FOOD_AA = 1;
    
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPERSSO, TEA;
    }
    enum Dessert implements Food {
        FRUIT, GELATO, TIRAMISU;
    }

    public static void main(String[] args) {
        Food food = Food.Coffee.ESPERSSO;//ESPERSSO不仅是coffee,也属于大类Food，达到分类的效果
        Integer foodAa = Food.FOOD_AA;
    }
}
