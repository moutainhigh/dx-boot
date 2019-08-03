package com.dx.zip;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Enumeration;

/**
 * Description: com.dx.zip
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/31
 */

public class AntZip {
    private ZipFile zipFile;
    private ZipOutputStream zipOut;     //压缩Zip
    private ZipEntry zipEntry;
    private int bufSize;    //size of bytes
    private byte[] buf;
    private int readedBytes;

    public AntZip() {
        this(512);
    }

    public AntZip(int bufSize) {
        this.bufSize = bufSize;
        this.buf = new byte[this.bufSize];
    }

    //压缩文件夹内的文件
    public void doZip(String zipDirectory) {//zipDirectoryPath:需要压缩的文件夹名
        File file;
        File zipDir;

        zipDir = new File(zipDirectory);
        String zipFileName = zipDir.getName() + ".zip";//压缩后生成的zip文件名

        try {
            this.zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName)));
            handleDir(zipDir, this.zipOut);
            this.zipOut.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //由doZip调用,递归完成目录文件读取
    private void handleDir(File dir, ZipOutputStream zipOut) throws IOException {
        FileInputStream fileIn;
        File[] files;

        files = dir.listFiles();

        if (files.length == 0) {//如果目录为空,则单独创建之.
            //ZipEntry的isDirectory()方法中,目录以"/"结尾.
            this.zipOut.putNextEntry(new ZipEntry(dir.toString() + "/"));
            this.zipOut.closeEntry();
        } else {//如果目录不为空,则分别处理目录和文件.
            for (File fileName : files) {
                //System.out.println(fileName);

                if (fileName.isDirectory()) {
                    handleDir(fileName, this.zipOut);
                } else {
                    fileIn = new FileInputStream(fileName);
                    this.zipOut.putNextEntry(new ZipEntry(fileName.toString()));

                    while ((this.readedBytes = fileIn.read(this.buf)) > 0) {
                        this.zipOut.write(this.buf, 0, this.readedBytes);
                    }

                    this.zipOut.closeEntry();
                }
            }
        }
    }

    //解压指定zip文件
    public void unZip(String unZipfileName) {//unZipfileName需要解压的zip文件名
        FileOutputStream fileOut;
        File file;
        InputStream inputStream;

        try {
            this.zipFile = new ZipFile(unZipfileName);

            for (Enumeration entries = this.zipFile.getEntries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                file = new File(entry.getName());

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    //如果指定文件的目录不存在,则创建之.
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    inputStream = zipFile.getInputStream(entry);

                    fileOut = new FileOutputStream(file);
                    while ((this.readedBytes = inputStream.read(this.buf)) > 0) {
                        fileOut.write(this.buf, 0, this.readedBytes);
                    }
                    fileOut.close();

                    inputStream.close();
                }
            }
            this.zipFile.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //设置缓冲区大小
    public void setBufSize(int bufSize) {
        this.bufSize = bufSize;
    }

    //测试AntZip类
    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            String name = args[1];
            AntZip zip = new AntZip();

            if (args[0].equals("-zip"))
                zip.doZip(name);
            else if (args[0].equals("-unzip"))
                zip.unZip(name);
        } else {
            System.out.println("Usage:");
            System.out.println("压缩:java AntZip -zip directoryName");
            System.out.println("解压:java AntZip -unzip fileName.zip");
            throw new Exception("Arguments error!");
        }
    }
}