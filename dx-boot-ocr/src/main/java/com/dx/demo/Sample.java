package com.dx.demo;


import com.baidu.aip.ocr.AipOcr;
import lombok.extern.log4j.Log4j;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-27
 */
@Log4j
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "";
    public static final String API_KEY = "";
    public static final String SECRET_KEY = "";



    public static JSONObject sample(AipOcr client) {

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("templateSign", "Nsdax2424asaAS791823112");
//        options.put("classifierId", "31232");

        // 参数为本地路径
        String image = "E:\\develop\\dx-boot-single\\dx-boot-ocr\\src\\main\\resources\\static\\test.png";
        //模板id
        String templateSign = "";

        JSONObject res = client.custom(image,templateSign, options);
        return res;
    }



    public static void main(String[] args) {
//        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        Function<AipOcr, JSONObject> sample = Sample::sample;

        JSONObject apply = sample.apply( client);

        log.info("结果数据是：  " + apply);


    }
}
