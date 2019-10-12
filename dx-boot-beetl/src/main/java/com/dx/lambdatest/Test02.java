package com.dx.lambdatest;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/29
 */
public class Test02 {

    public static void main(String[] args) throws IOException {
       /* ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/tpl");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/hello.txt");
        t.binding("name","tom");
        String str = t.render();
        System.out.println(str);*/
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/tpl");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/articlespecialwidget.html");
        t.binding("cmsWidgetbase","12");
        String str = t.render();
        System.out.println(str);

    }

}
