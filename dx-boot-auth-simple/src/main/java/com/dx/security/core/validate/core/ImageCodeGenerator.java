package com.dx.security.core.validate.core;

import com.dx.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;

/**
 * 图片验证码生成类
 * ClassName: ImageCodeGenerator 
 * @Description: TODO
 * @author lihaoyang
 * @date 2018年3月2日
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public ImageCode generator(ServletWebRequest request) {
		//先从request里读取有没有长、宽、字符个数参数，有的话就用，没有用默认的
		int width  = ServletRequestUtils.getIntParameter(request.getRequest(),
				"width",
				securityProperties.getCode().getImage().getWidth());
    	int height = ServletRequestUtils.getIntParameter(request.getRequest(),
				"height",
				securityProperties.getCode().getImage().getHeight());
    	int charLength =
				securityProperties.getCode().getImage().getLength();

		VerifyCode verifyCode = new VerifyCode(width,height,charLength);
		//调用一下这个方法才能往验证码text设置值
		BufferedImage bufferedImage = verifyCode.getImage();
		logger.info("-------ImageCodeGenerator.verifyCode.getText--------> "+verifyCode.getText());
		return new ImageCode(bufferedImage,verifyCode.getText(),this.securityProperties.getCode().getImage().getExpireIn());
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	

}
