package com.winterbe.java8.samples.efficiency;

/**
 * @Description 对比基本数据类型和包装类内存占用：考虑创建大量整数的情况，我们来演示int和Integer的内存占用情况：
 * 这个代码演示了用int和Integer计算累加和，并测量了它们的执行时间。
 */
public class MemoryComparison {
    public static void main(String[] args) {
        int sum1 = 0;
        Integer sum2 = 0;

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sum1 += i;
        }
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        for (Integer i = 0; i < 1000000; i++) {
            sum2 += i;
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("int sum: " + sum1);
        System.out.println("Time taken by int: " + (endTime1 - startTime1) + "ms");

        System.out.println("Integer sum: " + sum2);
        System.out.println("Time taken by Integer: " + (endTime2 - startTime2) + "ms");
    }
}