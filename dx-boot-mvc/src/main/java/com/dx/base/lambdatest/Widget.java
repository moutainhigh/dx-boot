package com.dx.base.lambdatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 清单 3. 一个流的操作示例
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/5/30
 */
public class Widget {
    private final Color color;
    private final int weight;

    enum Color {RED, BLACK, BLUE}

    public Widget(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(Color.RED, 1));
        widgets.add(new Widget(Color.RED, 2));
        widgets.add(new Widget(Color.BLACK, 3));
        widgets.add(new Widget(Color.BLUE, 4));
        // stream() 获取当前的source, filter 和 mapToInt为intermediate操作, 进行数据筛选和转换,
        // 最后一个sum为terminal操作，对符合条件的全部widget做重量求和
        int sum = widgets.stream()
                .filter(w -> w.getColor() == Color.RED)
                .mapToInt(Widget::getWeight)
                .sum();
        System.out.println(sum);// 3
    }
}
