package com.dx.zip;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * Description: com.dx.zip
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/30
 */
public class UnZipTest {


    public void test() throws IOException {
        File file = new File(UnZipTest.class.getClassLoader().getResource("zip/test.zip").getPath());
        ZipFile zip = new ZipFile(file);
        Enumeration<ZipEntry> entries = zip.getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry zipFile = entries.nextElement();
            File outFile = new File(UnZipTest.class.getClassLoader().getResource("zip2/").getPath() + zipFile.getName());
            InputStream inputStream = zip.getInputStream(zipFile);
            System.out.println(inputStream.toString() + "\n" + "kuoyi");
            FileUtils.copyInputStreamToFile(inputStream, outFile);
        }


    }

    public static void main(String[] args) throws IOException {

        UnZipTest unZipTest = new UnZipTest();
        unZipTest.test();

    }

}
