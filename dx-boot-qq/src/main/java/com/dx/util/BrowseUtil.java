package com.dx.util;

import java.awt.*;
import java.net.URI;

/**
 * Description: com.dx.util
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/1/19
 */
public class BrowseUtil {

    /**
     * 使用默认浏览器打开指定网页地址
     *
     * @param url 网页地址
     * @throws Exception
     */
    private static void browse2(String url) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(url);
            desktop.browse(uri);
        }
    }

}
