package org.learnit.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description 最大N个数与最小N个数的和
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * <p>
 * 说明：
 * 数组中数字范围[0, 1000]
 * 最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * 输入非法返回-1
 * 输入描述
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述
 * 输出最大N个数与最小N个数的和
 * 用例1
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明:最大2个数[100,95],最小2个数[83,64], 输出为342。
 * 用例2
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明:最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1。
 */
public class BothEndsOfArray {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int[] fields = new int[m];
            for (int i = 0; i < m; i++) {
                fields[i] = scanner.nextInt();
            }
            // ｎ表示最大N个数， 最小N个数
            int n = scanner.nextInt();
            System.out.println(solution(m, n, fields));
        }
    }

    static Integer solution(Integer m, Integer n, int[] fields) {
        try {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int k = 0; k < fields.length; k++) {
                treeSet.add(fields[k]);
            }
            Integer[] newFields = treeSet.toArray(new Integer[0]);

            m = newFields.length;
            if (m < n) {
                return -1;
            }

            if (m % 2 == 0) {
                if (m / 2 < n) {
                    return -1;
                }
            } else if ((m - 1) / 2 < n) {
                return -1;
            }

            Arrays.sort(newFields);
            int minSum = 0;
            for (int i = 0; i < n; i++) {
                minSum += newFields[i];
            }

            int maxSum = 0;
            for (int j = newFields.length - 1; j >= m - n; j--) {
                maxSum += newFields[j];
            }

            int rest = minSum + maxSum;
            return rest;
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return -1;
    }
}