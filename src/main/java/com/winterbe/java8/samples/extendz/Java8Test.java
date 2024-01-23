package com.winterbe.java8.samples.extendz;

/**
 * ClassA并没有实现InterfaceA接口中print方法，
 * InterfaceA接口中提供了print方法的默认实现，
 * 因此可以直接使用ClassA类的print方法
 */
public class Java8Test {

    public static void main(String[] args) {
        new ClassA().print(); //打印"InterfaceA print"
    }
}
