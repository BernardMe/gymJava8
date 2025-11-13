package com.winterbe.java8.samples.stackframe;

/**
 * 原始数据类型栈帧的局部变量数值交换测试01
 *
 * @author wangzhuo
 * @date 20251113
 */
public class StackFramePrimitiveType {

    public static void main(String[] args) {
        int a = 1, b = 2;
        swapInt(a, b);
        System.out.println("a=" + a + " , b=" + b);
    }
    private static void swapInt(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}