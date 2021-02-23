package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @discruption stream新特性collect
 * 又两条重复的Map<String, String>记录，此时我们想根据map的key进行去重应该怎么做呢？
 * 其中 new TreeSet<>(Comparator.comparing(m -> m.get("key1")))
 * 其中 m.get("key1")获取的对象需要 实现Comparator接口
 * @author wangzhuo
 */
public class Streams14 {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>(16) ;
        Map<String,String> map1 = new HashMap<>(16);
        map1.put("key1", "val1");
        Map<String,String> map2 = new HashMap<>(16);
        map2.put("key1", "val1");
        list.add(map1);
        list.add(map2);
        //打印list里面的数据
        list.forEach(System.out::println);

        ArrayList<Map<String, String>> data = list.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(m -> m.get("key1")))), ArrayList::new));
        System.out.println("=======去重前后分界线=======");
        //打印过滤后的数据
        data.forEach(System.out::println);
    }
}

