package com.dx.security.core.support;

/**
 * Description:认证处理控制器响应信息
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        super();
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
