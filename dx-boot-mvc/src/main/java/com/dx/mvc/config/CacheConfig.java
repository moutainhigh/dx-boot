//package com.dx.config;
//
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
///**
// * Description: com.dx.config
// *
// * @author yaoj
// * @version 1.0
// * @copyright Copyright (c) 文理电信
// * @since 2019/10/16
// */
//@Configuration
//public class CacheConfig {
//
//    // 整合ehcache
//    @Bean
//    public EhCacheCacheManager ehCacheCacheManager() {
//        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
//        return ehCacheCacheManager;
//    }
//
//
//    @Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        //ehcache配置文件
//        Resource r = new ClassPathResource("ehcache.xml");
//        cacheManagerFactoryBean.setConfigLocation(r);
//        return cacheManagerFactoryBean;
//    }
//
//
//}
