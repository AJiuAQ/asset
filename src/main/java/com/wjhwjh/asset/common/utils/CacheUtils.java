package com.wjhwjh.asset.common.utils;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * @author wjhwjh
 * @description Cache工具类
 * Created in 15:26 2019/8/26
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);

    private static final String SYS_CACHE = "sysCache";

    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(getKey(key), value);
    }

    /**
     * 获取缓存键名，多数据源下增加数据源名称前缀
     *
     * @param key
     * @return
     */
    private static String getKey(String key) {
//		String dsName = DataSourceHolder.getDataSourceName();
//		if (StringUtils.isNotBlank(dsName)){
//			return dsName + "_" + key;
//		}
        return key;
    }

    /**
     * 获得一个Cache，没有则显示日志。
     *
     * @param cacheName
     * @return
     */
    private static Cache<String, Object> getCache(String cacheName) {
        Cache<String, Object> cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new RuntimeException("当前系统中没有定义“" + cacheName + "”这个缓存。");
        }
        return cache;
    }
}
