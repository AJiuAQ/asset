package com.wjhwjh.asset.common.config;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author wjhwjh
 * @description 全局配置类
 * Created in 9:56 2019/8/27
 */
public class Global {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
//    private static PropertiesLoader loader = new PropertiesLoader("abcn.properties");

    /**
     * 获取配置
     */
//    public static String getConfig(String key) {
//        String value = map.get(key);
//        if (value == null){
//            value = loader.getProperty(key);
//            map.put(key, value != null ? value : StringUtils.EMPTY);
//        }
//        return value;
//    }
}
