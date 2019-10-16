package com.dx.controller;

import com.dx.security.bean.CacheBean;
import com.dx.security.bean.Student;
import com.dx.service.CacheService;
import com.dx.util.EhCacheService;
import com.dx.util.ValidatorUtil;
import com.dx.validata.ViliGroupOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/26
 */
@RestController
@Slf4j
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private EhCacheService ehCacheService;




    @GetMapping("/cache/get")
    public Object getStudent(
//            @Validated
//            @Range(min = 5, max = 9, message = "num只能从5-9")
//                    int num
            @Validated({ViliGroupOne.class})
            CacheBean cacheBean
    ){

        ValidatorUtil.validateEntity(cacheBean, ViliGroupOne.class);

        List<Student> studentList = cacheService.getStudent(cacheBean.getNum());

        return studentList;
    }


    @GetMapping("/cache/getdata")
    public Object get(String formdata){

        String data = ehCacheService.get(EhCacheService.INVOICE_PFDM_FPHM_CACHE, "key"+formdata);

        if (StringUtils.isEmpty(data)){
            log.info("从数据库中获取数据。。。。");
            data = "hello";
            ehCacheService.put(EhCacheService.INVOICE_PFDM_FPHM_CACHE,"key"+formdata ,data +formdata);
        }

        return data;
    }


    @GetMapping("/cache/getdata2")
    public Object get2(String formdata){

        ehCacheService.add(EhCacheService.FPQQLSH_CACHE, "value"+formdata);


        List<String> stringList = ehCacheService.get(EhCacheService.FPQQLSH_CACHE);

        stringList.forEach(s -> System.out.println(s));


        return stringList;
    }



}
