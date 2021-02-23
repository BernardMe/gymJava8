package com.winterbe.java8.samples.stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @discruption stream新特性filter
 * distinct（）不提供按照属性对对象列表进行去重的直接实现。它是基于hashCode（）和equals（）工作的。
 * 如果我们想要按照对象的属性，对对象列表进行去重，我们可以通过其它方法来实现
 * @author wangzhuo
 */
public class Streams15 {

    public static void main(String[] args) {

        //使用方法：用Stream接口的 filter()接收为参数

        ///List<User> lists = list.stream().filter(distinctByKey(User::getId)).collect(Collectors.toList());
    }

    /**
     * 对某个字段过滤重复数据：使用HashMap
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

