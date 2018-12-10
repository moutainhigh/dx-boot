//package com.dx.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author yaoj
// * @version 1.0
// * @copyright 广州明动软件有限公司 Copyright (c) 2018
// * @since 2018-12-10
// */
//@RestController
//public class TestEndpoints {
//
//    @GetMapping("/product/{id}")
//    public String getProduct(@PathVariable String id) {
//        //for debug
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return "product id : " + id;
//    }
//
//    @GetMapping("/order/{id}")
//    public String getOrder(@PathVariable String id) {
//        //for debug
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return "order id : " + id;
//    }
//
//}