package com.dx.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

/**
 * Description: com.dx.util
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/9
 */
public class AuthUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    private static ObjectMapper mapper = new ObjectMapper();


    public static final String APP_ID = "xxxx";

    public static final String APPSECURIT = "xxxxxx";

    public static String deGetJson(String url){

        String forObject = restTemplate.getForObject(url, String.class);

        return forObject.toString();
    }
}
