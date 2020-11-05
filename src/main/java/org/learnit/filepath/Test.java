package org.learnit.filepath;

import java.io.File;

/**
 * CLASSPATH文件的绝对路径获取测试
 *
 * @author leizhimin 2010-1-18 9:33:02
 */
public class Test {
    //classpath的文件路径
    private static String cp = "/cfg/syscfg.properties";

    public static void main(String[] args) {
        //当前类的绝对路径
        System.out.println(Test.class.getResource("/").getFile());
        //指定CLASSPATH文件的绝对路径
        System.out.println(Test.class.getResource(cp).getFile());
        //指定CLASSPATH文件的绝对路径
        File f = new File(Test.class.getResource(cp).getFile());
        System.out.println(f.getPath());
    }
}