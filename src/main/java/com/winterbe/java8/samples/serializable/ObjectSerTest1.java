package com.winterbe.java8.samples.serializable;

import java.io.*;

/**
 * <pre>
 * 序列化保存的是对象的状态，静态属性属于类的状态，所以序列化不能保存静态属性
 * 这个不能序列化的意思是，序列化的信息中不包含该静态成员域
 *
 * ObjectSerTest1 测试成功，
 * 是因为都在同一个机器（而且是同一个进程），因为这个jvm已经把count加载进来了，所以你获取的是加载好的count，
 *
 * 对比测试参照 >> com.winterbe.java8.samples.serializable.Test
 * </pre>
 *
 * @author
 */
class Student1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password;
    private static int count = 0;

    public Student1(String name, String password) {
        System.out.println("调用Student的带参的构造方法");
        this.name = name;
        this.password = password;
        count++;
    }

    public String toString() {
        return "人数: " + count + " 姓名: " + name + " 密码: " + password;
    }
}

public class ObjectSerTest1 {
    public static void main(String args[]) {
        try {

            FileOutputStream fos = new FileOutputStream("test.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Student1 s1 = new Student1("张三", "12345");
            Student1 s2 = new Student1("王五", "54321");

            oos.writeObject(s1);
            oos.writeObject(s2);

            oos.close();

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