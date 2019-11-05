package com.dx.mvc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Description: com.dx.util
 * ehcache工具类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/16
 */
@Service
public class EhCacheService {

    private final static Logger logger = LoggerFactory.getLogger(EhCacheService.class);

    @Autowired
    private CacheManager cacheManager;

    public static final String INVOICE_PFDM_FPHM_CACHE = "invoiceFpKeyCache";

    public static final String FPQQLSH_CACHE = "invoiceFpqqlshCache";

    /**
     * 添加String数据
     * @param cacheName
     * @param value
     */
    public void add(String cacheName, String value) {
        Cache cache = cacheManager.getCache(cacheName);
        List<String> list = cache.get(cacheName, ArrayList.class);
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        list.add(value);
        cache.put(cacheName, list);
    }

    /**
     * 获取数据
     * @param cacheName
     * @return
     */
    public List<String> get(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        List<String> list = cache.get(cacheName, ArrayList.class);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list;
    }

    /**
     * 判断是否包含数据
     * @param cacheName
     * @param value
     * @return
     */
    public boolean contains(String cacheName, String value) {
        Cache cache = cacheManager.getCache(cacheName);
        List<String> list = cache.get(cacheName, ArrayList.class);
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        return list.contains(value);
    }

    /**
     * 删除数据
     * @param cacheName
     * @param value
     */
    public void remove(String cacheName, String value) {
        Cache cache = cacheManager.getCache(cacheName);
        List<String> list = cache.get(cacheName, ArrayList.class);
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.remove(value);
        cache.put(cacheName, list);
    }

    /**
     * 添加数据
     * @param cacheName
     * @param key
     * @param value
     */
    public void put(String cacheName, String key, String value) {
        Cache cache = cacheManager.getCache(cacheName);
        Map<String, String> map = cache.get(cacheName, HashMap.class);
        if (CollectionUtils.isEmpty(map)) {
            map = new HashMap<>();
        }
        map.put(key, value);
        cache.put(cacheName, map);
    }

    /**
     * Map获取数据
     * @param cacheName
     * @param key
     * @return
     */
    public String get(String cacheName, String key) {
        Cache cache = cacheManager.getCache(cacheName);
        Map<String, String> map = cache.get(cacheName, HashMap.class);
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return map.get(key);
    }

    /**
     * Map获取数据
     * @param cacheName
     * @return
     */
    public List<String> getValues(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        Map<String, String> map = cache.get(cacheName, HashMap.class);
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        List<String> values = new ArrayList<>(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    /**
     * Map判断是否包含数据
     * @param cacheName
     * @param key
     * @return
     */
    public boolean containsKey(String cacheName, String key) {
        Cache cache = cacheManager.getCache(cacheName);
        Map<String, String> map = cache.get(cacheName, HashMap.class);
        if (CollectionUtils.isEmpty(map)) {
            return false;
        }
        return map.containsKey(key);
    }

    /**
     * Map删除数据
     * @param cacheName
     * @param key
     */
    public void removeKey(String cacheName, String key) {
        Cache cache = cacheManager.getCache(cacheName);
        Map<String, String> map = cache.get(cacheName, HashMap.class);
        if (CollectionUtils.isEmpty(map)) {
            return;
        }
        map.remove(key);
        cache.put(cacheName, map);
    }


}
