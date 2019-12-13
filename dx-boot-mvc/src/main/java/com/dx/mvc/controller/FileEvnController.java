package com.dx.mvc.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * Description: com.dx.mvc.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/6
 */
@RestController
@RequestMapping("/file")
public class FileEvnController {


    @RequestMapping("/getFile")
    public String getFile() throws Exception {
        String tplFile = "ok.html";

        File file = new File(tplFile);
        InputStream is = new FileInputStream(file);
//        Resource resource = new ClassPathResource(tplFile);
//        InputStream is = resource.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append("\r\n");
        }
        if (is != null) {
            is.close();
        }
        if (br != null) {
            br.close();
        }

        return sb.toString();
    }


    @RequestMapping("/createFile")
    public String createFile() throws Exception {
        File file = new File("ok.html");

        System.out.println(file.getAbsolutePath());

        if (!file.exists()){
            file.createNewFile();
        }
        return "ok";

    }


    @RequestMapping("/getPath")
    public String getPath() throws IOException {
        ClassPathResource cpr = new ClassPathResource("static/test.html");

        InputStream inputStream = cpr.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append("\r\n");
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (br != null) {
            br.close();
        }

        System.out.println("文件的内容是："   + sb.toString());


        return "ok";



    }


}
