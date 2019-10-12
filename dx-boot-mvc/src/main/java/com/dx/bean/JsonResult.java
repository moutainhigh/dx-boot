package com.dx.security.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@Data
@NoArgsConstructor
public class JsonResult implements Serializable {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 返回码 非-1即失败
     */
    private int code;
    /**
     * 消息提示
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Map<String, Object> data;

    public JsonResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static String success() {
        return success(new HashMap<>(0));
    }

    public static String success(Map<String, Object> data) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(new JsonResult(0, "解析成功", data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String failed() {
        return failed("解析失败");
    }

    public static String failed(String msg) {
        return failed(-1, msg);
    }

    public static String failed(int code, String msg) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(new JsonResult(code, msg, new HashMap<>(0)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}

