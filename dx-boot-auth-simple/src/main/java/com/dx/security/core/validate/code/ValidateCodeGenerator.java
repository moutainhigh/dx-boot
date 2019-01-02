package com.dx.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:验证码生成接口
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public interface ValidateCodeGenerator {

//	/**
//	 * 图片验证码生成接口
//	 * @Description: TODO
//	 * @param @param request
//	 * @param @return   
//	 * @return ImageCode  
//	 * @throws
//	 * @author lihaoyang
//	 * @date 2018年3月2日
//	 */
//	ImageCode generator(ServletWebRequest request);

    /**
     * @param request
     * @return
     */
    ValidateCode generator(ServletWebRequest request);

}
