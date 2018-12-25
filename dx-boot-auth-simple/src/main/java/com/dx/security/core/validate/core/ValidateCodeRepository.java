package com.dx.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description: 验证码存储策略
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-23
 */
public interface ValidateCodeRepository {

	/**
	 * 保存验证码
	 * @param request
	 * @param code 验证码
	 * @param validateCodeType 验证码类型
	 */
	void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

	/**
	 * 获取验证码
	 * @param request
	 * @param validateCodeType 验证码类型
	 * @return
	 */
	ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

	/**
	 * 移出验证码
	 * @param request
	 * @param validateCodeType 验证码类型
	 */
	void remove(ServletWebRequest request, ValidateCodeType validateCodeType);
}
