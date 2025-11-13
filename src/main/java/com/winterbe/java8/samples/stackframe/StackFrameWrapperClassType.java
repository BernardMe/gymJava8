package com.winterbe.java8.samples.stackframe;

/**
 * 包装数据类型栈帧的局部变量数值交换测试01
 *
 * @author wangzhuo
 * @date 20251113
 */
public class StackFrameWrapperClassType {

    public static void main(String[] args) {
        Integer a = 1, b = 2;
        swapInteger(a, b);
        System.out.println("a=" + a + " , b=" + b);
    }
    private static void swapInteger(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}