package com.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/16
 */
@Controller
public class FileController {

   @RequestMapping("/fileUpload")
   private String fileUpload(){
        return "fileUpload";
   }

}
