package com.dx.mvc.controller;

import com.dx.mvc.bean.School;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.mvc.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/13
 */
@Slf4j
@RestController
@RequestMapping("/testJson")
public class TestJsonController {


    private ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping("/test")
    public String test(@RequestBody School school){

        log.info("数据是：{}", school);

        try {
            String s = objectMapper.writeValueAsString(school);
            log.info("转的json是：{}",s );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return "ok";
    }



}
