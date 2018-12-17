package com.dx.security.core.validate.code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码Controller
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @GetMapping("/verifycode/image")
    public void createCode(HttpServletRequest request,HttpServletResponse response) throws IOException {

        ImageCode imageCode = createImageCode(request, response);
        request.getSession().setAttribute(SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }


    private ImageCode createImageCode(HttpServletRequest request, HttpServletResponse response) {
        VerifyCode verifyCode = new VerifyCode();
        return new ImageCode(verifyCode.getImage(),verifyCode.getText(),60);
    }

}
