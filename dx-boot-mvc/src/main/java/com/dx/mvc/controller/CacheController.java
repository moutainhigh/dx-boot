package com.dx.mvc.controller;

import com.dx.mvc.bean.CacheBean;
import com.dx.mvc.bean.Student;
import com.dx.mvc.service.CacheService;
import com.dx.mvc.util.EhCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: com.dx.controller
 * <p>
 * 带了校验
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
//            @Validated({ViliGroupOne.class})
            CacheBean cacheBean
    ) {

        //校验
//        ValidatorUtil.validateEntity(cacheBean, ViliGroupOne.class);

        List<Student> studentList = cacheService.getStudent(cacheBean.getNum());

        return studentList;
    }


    @GetMapping("/cache/getDefualt")
    public Object getDefualt(CacheBean cacheBean) {

        List<Student> studentList = cacheService.getDefualt(cacheBean.getNum());

        return studentList;
    }


    /**
     * 实用性不强
     *
     * @param formdata
     * @return
     */
    @GetMapping("/cache/getdata")
    public Object get(String formdata) {

        String data = ehCacheService.get(EhCacheService.INVOICE_PFDM_FPHM_CACHE, "key" + formdata);

        if (StringUtils.isEmpty(data)) {
            log.info("从数据库中获取数据。。。。");
            data = "hello";
            ehCacheService.put(EhCacheService.INVOICE_PFDM_FPHM_CACHE, "key" + formdata, data + formdata);
        }

        return data;
    }


    /**
     * 实用性不强
     *
     * @param formdata
     * @return
     */
    @GetMapping("/cache/getdata2")
    public Object get2(String formdata) {

        ehCacheService.add(EhCacheService.FPQQLSH_CACHE, "value" + formdata);


        List<String> stringList = ehCacheService.get(EhCacheService.FPQQLSH_CACHE);

        stringList.forEach(s -> System.out.println(s));


        return stringList;
    }


}
