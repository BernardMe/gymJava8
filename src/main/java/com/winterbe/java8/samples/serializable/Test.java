package com.winterbe.java8.samples.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <pre>
 * 序列化保存的是对象的状态，静态属性属于类的状态，所以序列化不能保存静态属性
 * 这个不能序列化的意思是，序列化的信息中不包含该静态成员域
 *
 * Java序列化测试类.
 *
 * 如果你是传到另一台机器或者你关掉程序重写写个程序读入test.obj，
 * 此时因为别的机器或新的进程是重新加载count的，所以count信息就是初始时的信息。
 *
 * Created by wanghuaikang on 20210421.
 * </pre>
 *
 * @author
 */
public class Test{



    public static void main(String args[]){

        try {

            FileInputStream fis = new FileInputStream("test.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student1 s3 = (Student1) ois.readObject();
            Student1 s4 = (Student1) ois.readObject();

            System.out.println(s3);
            System.out.println(s4);

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }



}
