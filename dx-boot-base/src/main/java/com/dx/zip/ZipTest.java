package com.dx.zip;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;

/**
 * Description: com.dx.zip
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/31
 */
public class ZipTest {

    private boolean zip(String dirName) throws IOException {
        //1.获取zip输出流
        ZipOutputStream zipOutputStream;
        File file = new File(dirName);
        if (file.isDirectory()) {
            zipOutputStream = new ZipOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("e:/" + file.getName() + ".zip")));
        } else {
            throw new RuntimeException("需要选择文件夹进行压缩");
        }


        //2.设置zipoutputstream输出流
        setOutputStream(dirName,zipOutputStream);

        zipOutputStream.close();


        return true;
    }


    /**
     * 给zipoutput设置内容
     *
     * @param dirName
     * @param zipOutputStream
     */
    public void setOutputStream(String dirName, ZipOutputStream zipOutputStream) throws IOException {
        File file = new File(dirName);
        File[] files = file.listFiles();
        //1.如果没有文件或文件夹
        if (files.length == 0) {
            zipOutputStream.putNextEntry(new ZipEntry(dirName.toString() + "/"));
            zipOutputStream.closeEntry();
        } else {
            //2.如果有文件或文件夹
            for (File tempFile : files) {
                if (tempFile.isDirectory()) {
                    setOutputStream(tempFile.getPath(), zipOutputStream);
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(tempFile.getName()));
                    FileUtils.copyFile(tempFile, zipOutputStream);
                    IOUtils.copy(new FileInputStream(tempFile),zipOutputStream);

                    zipOutputStream.closeEntry();
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        ZipTest zipTest = new ZipTest();

        String dirFile = "E:/logs";

        boolean flag = zipTest.zip(dirFile);


    }


}
