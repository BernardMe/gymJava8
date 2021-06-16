package org.third.util;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

public final class BeanUtil {

    /**
     * 公共beanToMap方法
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, ?> beanToMap(T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        Map<String, Object> map = new HashMap<>();

        beanMap.forEach((key, value) -> {
            map.put(String.valueOf(key), value);
        });
        return map;
    }

    /**
     * 公共mapToBean方法
     *
     * @param map
     * @param clazz
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T mapToBean(Map<String, ?> map, Class<T> clazz)
            throws IllegalAccessException, InstantiationException {
        T bean = clazz.newInstance();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
