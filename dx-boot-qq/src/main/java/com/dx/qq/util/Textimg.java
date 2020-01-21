package com.dx.qq.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.qq.util
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/1/19
 */
@Slf4j
public class Textimg {

    public Textimg getobj() {
        return new Textimg();
    }

    private int minindex;
    private int maxindex;
    private List<String> textimg = new ArrayList<String>();

    public Textimg() {

    }

    public void addline(String data) {
        textimg.add(data);
        if (this.getmaxindex(data) != -1 && this.maxindex < this.getmaxindex(data)) {
            this.maxindex = this.getmaxindex(data);
        }
        if (this.getminindex(data) != -1 && this.minindex > this.getminindex(data)) {
            this.minindex = this.getminindex(data);
        }

    }

    public int getminindex(String data) {
        int index = 0;
        while (index < data.length()) {
            if (!String.valueOf(data.charAt(index)).equals(" ")) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    public int getmaxindex(String data) {
        int index = data.length() - 1;
        while (index > -1) {
            if (!String.valueOf(data.charAt(index)).equals(" ")) {
                return index;
            }
            index -= 1;
        }
        return -1;
    }

    public String getresultString() {
        String result = "";
        for (int i = 0; i < this.textimg.size(); i += 1) {
            result += this.textimg.get(i).substring(this.minindex, this.maxindex) + "\n";
        }
        return result.replaceAll("\n$", "");
    }
}
