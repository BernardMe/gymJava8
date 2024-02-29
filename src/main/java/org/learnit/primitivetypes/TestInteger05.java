package org.learnit.primitivetypes;

/**
 * Integer类型计算测试05
 *
 * 当需要进行自动装箱时，如果数值在 [-128 至 127] 之间时，会直接使用缓存中的对象，而不是重新创建一个对象。
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
public class TestInteger05 {

    public static void main(String[] args) {

        // 1）基本类型和包装类型
        int a = 100;
        Integer b = 100;  //自动装箱
        System.out.println(a == b);  //Integer(100)会自动拆箱为int类型再进行比较  true

        // 2）两个包装类型
        Integer c = 100;
        Integer d = 100;  //如果数值在 [-128 至 127] 之间时，会直接使用缓存中的对象
        System.out.println(c == d);  //true

        // 3）
        c = 200;
        d = 200;
        System.out.println(c == d);  //false
    }
}