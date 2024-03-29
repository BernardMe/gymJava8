package org.learnit.algorithm;

import java.util.Arrays;

/**
 * Leetcode_66. 加一
 * 简单
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] target = digits.clone();
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            target[i] = (target[i] + 1) % 10;
            if(target[i] == 0) {
                carry = 1;
                target[i] = 0;
            } else {
                return target;
            }
        }

        if (carry == 1) {
            target = new int[target.length + 1];
            target[0] = 1;
        }
        return target;
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        System.out.println(Arrays.toString(test.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
