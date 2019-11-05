package com.dx.base.enumtest;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-15
 */
public enum Info {



    MONDAY(1,"星期一"),
    TUESDAY(2,"星期二"),
    WEDNESDAY(3,"星期三");

    private int index;
    private String name;

    Info(int index, String name) {
        this.index = index;
        this.name = name;
    }


    public String getVal(int index){
        for (Info c : Info.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public int getIndex(String name){
        for (Info c : Info.values()) {
            if (c.getName() == name) {
                return c.index;
            }
        }
        return -1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
