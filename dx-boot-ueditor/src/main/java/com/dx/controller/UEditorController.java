package com.dx.controller;

import com.dx.baidu.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by ldb on 2017/4/9.
 */
@Controller
public class UEditorController {


    private String configFileName ="config.json";

    @RequestMapping("/")
    private String showPage() {
        return "index";
    }

    @RequestMapping(value = "/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath,configFileName).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Value("${web.upload-path}")
    private String path;

    @GetMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName) {

        if (fileName != null) {
            File file = new File(path + fileName);
            if (file.exists()) {
                // 设置强制下载不打开
//                response.setContentType("application/force-download");
                // 设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


//        FileInputStream inputStream = null;
//        ServletOutputStream os = null;
//
//        File file = new File(path + fileName);
//
//        try {
//            inputStream = new FileInputStream(file);
//
//            //设置响应状态200
//            response.setStatus(HttpServletResponse.SC_OK);
//            //设置内容类型
//            response.setContentType(getContentType(fileId));
//            //添加响应头 设置内容长度
//            response.addHeader("Content-Length", String.valueOf(file.length()));
//            //添加响应头 设置允许浏览器可尝试恢复中断的下载
//            response.addHeader("Accept-Ranges", "bytes");
//            response.addHeader("Cache-control", "private");
//            //添加响应头 设置浏览器另存为对话框的默认文件名
//            response.addHeader("Content-Disposition", "filename=" + file.getName());
//            response.addHeader("Last-Modified", new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss Z", Locale.ENGLISH).format(file.lastModified()) + " GMT");
//
//            os = response.getOutputStream();
//
//            byte[] buf = new byte[1024];
//            int len;
//            while ((len = inputStream.read(buf)) != -1) {
//                os.write(buf, 0, len);
//                os.flush();
//            }
//        } catch (Exception e) {
//            //操作文件失败时返回响应状态 500
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        } finally {
//            //结束后释放资源
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }


}
