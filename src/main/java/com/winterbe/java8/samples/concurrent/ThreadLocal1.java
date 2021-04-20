package com.winterbe.java8.samples.concurrent;

import com.alibaba.fastjson.JSON;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <pre>
 *
 * Thread维护ThreadLocal与实例的映射
 * 如果该 Map 由 Thread 维护，从而使得每个 Thread 只访问自己的 Map，那就不存在多线程写的问题，也就不需要锁
 *
 * Created by wanghuaikang on 20210421.
 * </pre>
 *
 */
public class ThreadLocal1 {

        private static Logger logger = LogManager.getLogger(ThreadLocal1.class);
        private static ThreadLocal<UserInfo> THREAD = new ThreadLocal<>();

        public static void set(UserInfo model)
        {
            THREAD.set(model);
        }

        public static UserInfo get()
        {
            return (UserInfo)THREAD.get();
        }

        public static void remove()
        {
            THREAD.set(null);
            THREAD.remove();
        }

        public static void main(String[] args)
        {
            UserInfo model = new UserInfo();
            model.setUserId(Long.valueOf(1L));
            model.setRole("1");
            set(model);
            System.out.println("取值=" + JSON.toJSONString(model));
            UserInfo model2 = new UserInfo();
            model2.setUserId(Long.valueOf(2L));
            model2.setRole("2");
            //set(model2);
            System.out.println("取值2=" + JSON.toJSONString(model2));
        }
    }
