package com.dx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: com.dx
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/10
 */
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/get")
    public String get(){

        return "get ....";
    }

    @GetMapping("/index")
    public String index(){

        return "index";
    }


}
