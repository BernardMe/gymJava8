package org.learnit.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *@Description 快递货车(贪心算法)
 *一辆运送快递的货车，
 *运送的快递放在大小不等的长方体快递盒中，
 *为了能够装载更多的快递同时不能让货车超载，
 *需要计算最多能装多少个快递。
 *注：快递的体积不受限制。
 *快递数最多1000个，货车载重最大50000。
 *
 *输入描述
 *第一行输入每个快递的重量
 *用英文逗号隔开
 *如 5,10,2,11
 *第二行输入货车的载重量
 *如 20
 *
 *输出描述
 *输出最多能装多少个快递
 */
public class ExpressTruck {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputLine = scanner.nextLine();
            String totalWeight = scanner.nextLine();


            solution(inputLine, totalWeight);
        }
    }

    private static void solution(String line, String total) {

        String[] goodWeights = line.split(",");
        int[] weights = new int[goodWeights.length];
        for (int i = 0; i < goodWeights.length; i++) {
            weights[i] = Integer.parseInt(goodWeights[i]);
        }
        int totalWeight = Integer.parseInt(total.trim());

        int sum = 0;
        int i = 0;
        try {

            Arrays.sort(weights);
            while (i < weights.length && (sum + weights[i]) <= totalWeight) {
                if (sum + weights[i] == totalWeight) {
                    i++;
                    break;
                }
                sum = sum + weights[i];
                i++;
            }

            System.out.println(i);

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
