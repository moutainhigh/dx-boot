package com.dx.security.controller;

import com.dx.util.AuthUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/9
 */
@Controller
@RequestMapping
@Slf4j
public class WxController {

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/wxLogin")
    public String get() {
        String backUrl = "http://2523a423r4.qicp.vip/WxAuth/callBack";

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + AuthUtil.APP_ID +
                "&redirect_uri=" + URLEncoder.encode(backUrl) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";

        log.info("调用了回调");

        return "redirect:" + url;
    }

    @ResponseBody
    @RequestMapping("/WxAuth/callBack")
    public Object get(HttpServletRequest request) {

        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + AuthUtil.APP_ID +
                "&secret=" + AuthUtil.APPSECURIT +
                "&code=" + code +
                "&grant_type=authorization_code";

        String result = AuthUtil.deGetJson(url);

        HashMap map = null;
        String accessToken = null;
        String openid = null;
        try {
            map = objectMapper.readValue(result, HashMap.class);
            accessToken = (String) map.get("access_token");
            openid = (String) map.get("openid");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + accessToken +
                "&openid=" + openid +
                "&lang=zh_CN";

        String userInfo = AuthUtil.deGetJson(infoUrl);
        System.out.println(userInfo);

        //TODO 这快可以做绑定系统用户的操作:
        // 1:如果绑定了，直接到需要去的页面
        // 2：如果没跳转跳转到绑定用户界面


        return "您登录成功后，后台获取到您的信息是：" + userInfo;
    }


}
