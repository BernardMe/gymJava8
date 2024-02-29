package org.learnit.primitivetypes;

/**
 * Integer类型计算测试01
 *
 * @author wangzhuo
 */
public class TestInteger01 {

    public static void main(String[] args) {

        Integer a = new Integer("50");
        Integer b = new Integer("10");
        Integer c = new Integer("20");

        // 一次减法计算
        System.out.println(String.format("一次减法计算: %s", a - b));
        // 两次次减法计算
        System.out.println(String.format("两次次减法计算: %s", a - b - c));
        // 多次次减法计算
        System.out.println(String.format("两次次减法计算: %s", a - (b - c)));
    }
}