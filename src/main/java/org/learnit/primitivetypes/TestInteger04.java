package org.learnit.primitivetypes;

/**
 * Integer类型计算测试04
 *
 * new Integer(123) 与 Integer.valueOf(123) 的区别在于:
 * new Integer(123) 每次都会新建一个对象
 * Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
 * valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
 * ```Java8中源码
 * public static Integer valueOf(int i) {
 *     if (i >= IntegerCache.low && i <= IntegerCache.high)
 *         return IntegerCache.cache[i + (-IntegerCache.low)];
 *     return new Integer(i);
 * }
 * ```
 * @author wangzhuo
 */
public class TestInteger04 {

    public static void main(String[] args) {

        Integer a = new Integer("20");
        Integer b = new Integer("20");
        Integer c = Integer.valueOf("20");
        Integer d = Integer.valueOf("20");

        // 一次比较计算
        System.out.println(String.format("new Integer(\"20\") 和 new Integer(\"20\") 一次比较计算: %s", a == b));
        // 再次比较计算
        System.out.println(String.format("new Integer(\"20\") 和 Integer.valueOf(\"20\") 再次比较计算: %s", a == c));
        // 再次比较计算
        System.out.println(String.format("Integer.valueOf(\"20\") 和 Integer.valueOf(\"20\") 再次比较计算: %s", c == d));
    }
}