package com.dx.commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Description: com.dx.commonsio
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/27
 */
public class FileReadTest {


    public static void main(String[] args) throws IOException {

        File file = new File("E:/logs/common-default.log");


        long l = FileUtils.sizeOf(file);

        System.out.println(l);

        List<String> gbk = FileUtils.readLines(file, "null");


        for (String s : gbk) {
            System.out.println("内容是：====》" + s);
        }


    }

}
