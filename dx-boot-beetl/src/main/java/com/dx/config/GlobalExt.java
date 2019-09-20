package com.dx.config;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: com.dx.config
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/20
 */
public class GlobalExt implements WebRenderExt {

    @Override
    public void modify(Template template, GroupTemplate arg1, HttpServletRequest request, HttpServletResponse response) {
        String ctxPath = request.getContextPath();
        template.binding("ctxFront", (ctxPath + "/f"));
        template.binding("ctx", (ctxPath + "/a"));
        template.binding("ctxStatic", (ctxPath + "/static"));
        template.binding("flow", ctxPath);
        template.binding("ctxStatic2", (ctxPath + "/"));
    }

}

