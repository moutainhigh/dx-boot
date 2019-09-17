package com.dx.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Description: com.dx.util
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Component
@Data
public class AppData {

    private HashMap loginMap = new HashMap();

    private HashMap userMap = new HashMap(){
        {
            put("root","root");
            put("admin","admin");
        }
    };


}
