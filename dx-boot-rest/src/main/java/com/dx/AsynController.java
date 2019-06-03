package com.dx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * 
 * ClassName: AsynController 
 * @Description:
 * @author lihaoyang
 * @date 2018年2月27日
 */
@RestController
public class AsynController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("/order")
    public Callable<String> order() throws Exception{
        System.err.println("-------进入AsynController------");
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {

            @Override
            public String call() throws Exception {
                logger.info("++ 副线程开始");
                Thread.sleep(5000);
                logger.info("++ 副线程返回");
                return "success";
            }
        };
        logger.info("主线程返回");
        return result;
    }
    
}
