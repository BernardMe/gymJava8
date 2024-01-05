package org.learnit.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@Description 题目描述
 * 某农场主管理了一大片果园，fields[i]
 * 表示不同果林的面积，单位:(m^2)，现在要为所有的果林施肥且必须在 n
 * 天之内完成，否则影响收成。小布是果林的工作人员，他每次选择一片果林进行施肥，且
 * 一片果林施肥完后当天不再进行施肥作业。假设施肥机的能效为 k，单位:(m^2/day)，请问
 * 至少租赁能效
 * k 为多少的施肥机才能确保不影响收成？如果无法完成施肥任务，则返回 -1。
 * 输入描述
 * 第一行输入为 m 和 n，m 表示 fields 中的元素个数，n 表示施肥任务必须在 n 天内（含 n
 * 天）完成；
 * 第二行输入为 fields，fields[i] 表示果林 i 的面积，单位:(m^2)
 *  * 输出描述
 * 对于每组数据，输出最小施肥机的能效 k，无多余空格
 */
public class LazyFarmerBu {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] fields = new int[m];
            for (int i = 0; i < m; i++) {
                fields[i]  = scanner.nextInt();
            }
            int rest = solution(m, n, fields);
            System.out.println(rest);

        }
    }

    private static int solution(int m, int n, int[] fields) {

        if (m > n) {
            return -1;
        }

        Arrays.sort(fields);
        for (int k = fields[0]; k < fields[fields.length - 1]; k++) {
            int days = 0;
            for (int field : fields) {
                if (field <= k) {
                    days++;
                } else {
                    while (field > 0) {
                        days++;
                        field -= k;
                    }
                }
                if (days > n) {
                    break;
                }
            }
            if (days == n) {
                return k;
            }
        }
        return -1;
    }
}
