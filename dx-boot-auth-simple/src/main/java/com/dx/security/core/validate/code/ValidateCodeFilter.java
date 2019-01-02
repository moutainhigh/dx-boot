package com.dx.security.core.validate.code;

import com.dx.security.core.exception.ValidateCodeException;
import com.dx.security.core.properties.SecurityConstants;
import com.dx.security.core.properties.SecurityProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 处理登录验证码过滤器
 * 继承OncePerRequestFilter：spring提供的工具，保证过滤器每次只会被调用一次
 * 实现 InitializingBean接口的目的：
 * 在其他参数都组装完毕的时候，初始化需要拦截的urls的值
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-1-2
 */
@Data
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    /**
     * 认证失败处理器
     */
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 验证码存储策略
     */
    private ValidateCodeRepository validateCodeRepository;

    /**
     * 需要拦截的url集合
     */
    private Set<String> urls = new HashSet<>();

    /**
     * 读取配置
     */
    private SecurityProperties securityProperties;

    /**
     * spring工具类
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 重写InitializingBean的方法，设置需要拦截的urls
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        //读取配置的拦截的urls
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
        //如果配置了需要验证码拦截的url，不判断，如果没有配置会空指针
        if (configUrls != null && configUrls.length > 0) {
            for (String configUrl : configUrls) {
                log.info("ValidateCodeFilter.afterPropertiesSet()--->配置了验证码拦截接口:" + configUrl);
                urls.add(configUrl);
            }
        } else {
            log.info("----->没有配置拦验证码拦截接口<-------");
        }
        //登录的请求一定拦截
        urls.add(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        /**
         * 可配置的验证码校验
         * 判断请求的url和配置的是否有匹配的，匹配上了就过滤
         */
        boolean action = false;
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }
        }
        if (action) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                //调用错误处理器，最终调用自己的
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;//结束方法，不再调用过滤器链
            }
        }

        //不是登录请求，调用其它过滤器链
        filterChain.doFilter(request, response);
    }

    /**
     * 校验验证码
     *
     * @param request
     * @throws ServletRequestBindingException
     */
    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        //从存储策略里拿验证码，app和browser不一样，依赖谁用谁
        ValidateCode validateCode = validateCodeRepository.get(request, ValidateCodeType.IMAGE);

        //拿出请求中的验证码
        String imageCodeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE);
        //校验
        if (StringUtils.isBlank(imageCodeInRequest)) {
            throw new ValidateCodeException("验证码不能为空");
        }
        if (validateCode == null) {
            throw new ValidateCodeException("验证码不存在，请刷新验证码");
        }
        if (validateCode.isExpired()) {
            //从session移除过期的验证码
            validateCodeRepository.remove(request, ValidateCodeType.IMAGE);
            throw new ValidateCodeException("验证码已过期，请刷新验证码");
        }
        if (!StringUtils.equalsIgnoreCase(validateCode.getCode(), imageCodeInRequest)) {
            throw new ValidateCodeException("验证码错误");
        }
        //验证通过，移除session中验证码
        validateCodeRepository.remove(request, ValidateCodeType.IMAGE);
    }

}
