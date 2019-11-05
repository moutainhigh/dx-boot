package com.dx.base.zip;

import java.io.File;

/**
 * Description: com.dx.zip
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/5
 */
public class Demo {

    public static void main(String[] args) {

        String dirName = "E:/logs";

        File[] files = new File(dirName).listFiles();

        for (File file : files) {
            System.out.println(file.getName());

            if (file.isDirectory()){
                File[] files1 = file.listFiles();
                System.out.println(files1.length);
            }

        }

    }

}
