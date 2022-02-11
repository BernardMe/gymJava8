package org.learnit.numerical;

/**
 * Integer类型计算测试03
 * @Description 这明明看着都是一模一样的，为什么却会输出两个截然不同的结果呢？
 *   The Integer class wraps a value of the primitive type int in an object. An object of type Integer contains a single field whose type is int.
 *
 * Integer类以一个对象的方式包裹了一个基本类型int的值。一个object类型的Integer包含了包含了一个类型是int类型的单独的成员变量。
 *
 * In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int.
 *
 * 并且这个类提供了多种方法，比如转换一个int类型为一个String类型，或者把一个String类型转换为int类型，还包含了其他当你要处理int时有用的常量和方法
 *
 * 原来这个类包含了处理int的各种方法和常量，开始提到了一个单词wraps，就是包裹的意思，那么我们java中也就习惯把这种和Integer相似的类统一称作包装类。
 *
 * 那么Integer是一个类，所以我们用“==”进行比较时，必然是比较的是地址，而不是值，那就说明赋值1给它时，他们指向的是同一个对象，这到底是发生了什么呢？
 *
 * 我们来看一下Integer中有一个私有的静态内部类IntegerCache，看一下看它的注释
 *
 * * Cache to support the object identity semantics of autoboxing for values between
 *      * -128 and 127 (inclusive) as required by JLS.
 *      *
 *      * The cache is initialized on first usage.  The size of the cache
 *      * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
 *      * During VM initialization, java.lang.Integer.IntegerCache.high property
 *      * may be set and saved in the private system properties in the
 *      * sun.misc.VM class.
 * 那么这里提到了当我们给一个-128到127的值进行自动包装时（也就是我们经常听到的装箱），它用来支持他们成为同一个身份。
 *
 * 根据他的类名，Integer缓存，也就是通过缓存的方式当我们给-128到127的值包装时会指向同一个对象，所以开始我们的num1==num2返回了true，同时我们的值可以不用是1，而是-128到127的任何一个数，他们都会返回true。
 *
 * The Integer class wraps a value of the primitive type int in an object. An object of type Integer contains a single field whose type is int.
 *
 * Integer类以一个对象的方式包裹了一个基本类型int的值。一个object类型的Integer包含了包含了一个类型是int类型的单独的成员变量。
 *
 * In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int.
 * 
 *
 *
 * @Reference  java技术大本营 java每日一练(19_03_10)
 * @author wangzhuo
 * @date 20220211
 */
public class TestInteger03 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;

        Integer c = 222;
        Integer d = 222;

        // Integer类型对于表示[-128~127]的整数数据值 都会使用基本类型int表示范围作为缓存

        // 基本类型int表示范围内
        System.out.println(a == b);  //true
        // 基本类型int表示范围外
        System.out.println(c == d);  //false
    }
}