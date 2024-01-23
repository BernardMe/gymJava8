package com.winterbe.java8.samples.extendz;

public class Person {

    public String name;
    int age = 25;

    public Person() {}

    public Person(String name) {

        setName(name);
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //普通方法
    public  String  introduce(){
        return  "个人信息： 姓名："+name+",年龄："+age;
    }
    //私有方法
    private  void   study(){
        System.out.println("good good study , day day up!");
    }
}
