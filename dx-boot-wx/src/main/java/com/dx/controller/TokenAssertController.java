package com.dx.security.controller;

import com.dx.util.WxTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/10
 */
@RequestMapping("/wechat")
@Controller
@Slf4j
public class TokenAssertController {


    @RequestMapping(value = "/wx.do")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.error("WechatController   ----   WechatController");

        System.out.println("========WechatController========= ");
        log.info("请求进来了...");

        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            // out.print(name + "=" + value);

            String log1 = "name =" + name + "     value =" + value;
            log.error(log1);
        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();

        if (WxTokenUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println(echostr);
            out.print(echostr);
        }
        out.close();
        out = null;

    }

}
