package com.dx.mvc.swagger.controller;

import com.dx.mvc.swagger.bean.UserEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-4
 */
@RestController
@RequestMapping("test2")
@Api(value="测试接口Controller",tags="测试接口模块")
public class Test2Controller {


    /**
     *
     * @param name
     * @param id
     * @return
     */
    @ApiOperation(value="测试用接口", notes="这个是测试接口，必须要传入name名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value="用户姓名", dataType = "String", required=true, paramType="form"),
            @ApiImplicitParam(name="id", value="id", dataType = "int", required=false, paramType="form")
    })
    @RequestMapping(value = "hello",method = {RequestMethod.POST,RequestMethod.GET})
    public String HelloWord(String name,Integer id) {
        return "2222222222222222Hello Word   name:" + name + "     id:   " + id;
    }


    /**
     *
     * @param name
     * @return
     */
    @ApiOperation(value="获取姓名的接口", notes="传入名称，获取姓名")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value="名称", dataType = "String", required=true, paramType="json"),
    })
    @RequestMapping(value = "getName",method = {RequestMethod.POST})
    public String getName(@RequestBody String name) {
        return "your  name:" + name;
    }


    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value="获取id的接口", notes="传入id，获取id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="名称", dataType = "String", required=true, paramType="path"),
    })
    @RequestMapping(value = "/getId/{id}",method = {RequestMethod.POST})
    public String getId(@PathVariable String id) {
        return "your  id:" + id;
    }


    /**
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "更改用户信息",notes = "把用户的信息修改了")
    @ApiParam(name="用户对象",value="传入json格式",required=true)
    @PostMapping("/save")
    public int save(@RequestBody UserEntity user){


        return 1;
    }


    /**
     *
     * @param id
     * @return
     */
    @ApiOperation("获取用户")
    @ApiParam(name="id",value="id对象",required=true)
    @PostMapping("/update/{id}")
    public Map update(@PathVariable String id){

        UserEntity userEntity = new UserEntity();
        userEntity.setId("11");

        Map map = new HashMap<String,Object>();
        map.put("code",400);
        map.put("message","成功");
        map.put("data",userEntity);


        return map;
    }

}
