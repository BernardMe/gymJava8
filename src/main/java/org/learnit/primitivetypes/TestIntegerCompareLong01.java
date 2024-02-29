package org.learnit.primitivetypes;

/**
 * Integer与Long类型比较计算测试01
 *
 * @author wangzhuo
 */
public class TestIntegerCompareLong01 {

    public static void main(String[] args) {

        long a = 200;
        Integer b = 200;  //自动装箱
        Integer c = new Integer("200");

        // 一次==比较计算
        System.out.println(String.format("long字面量200 和 Integer字面量200 ==比较计算: %s", a == b));
        // 再次equals比较计算
        System.out.println(String.format("long字面量200 和 Integer字面量200 equals比较计算: %s", b.equals(a)));
        // 再再次==比较计算
        System.out.println(String.format("Integer字面量200 和 new Integer(\"200\") ==比较计算: %s", a == c));
    }
}