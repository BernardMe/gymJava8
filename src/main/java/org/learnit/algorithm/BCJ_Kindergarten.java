package org.learnit.algorithm;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *@Description 题目描述
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友同班，请你帮忙把同班的小朋友找出来。
 *
 * 小朋友的编号是整数，与前一位小朋友同班用Y表示，不同班用N表示。
 *
 * 输入描述：
 * 输入为空格分开的小朋友编号和是否同班标志。
 *
 * 输出描述：
 * 输出为两行，每一行记录一个班小朋友的编号，编号用空格分开，且：
 * 1.编号需按照升序排列。
 * 2.若只有一个班的小朋友，第二行为空行。
 *
 * 比如：
 * 输入 1/N 2/Y 3/N 4/Y
 * 输出 1 2
 * 3 4
 */
public class BCJ_Kindergarten {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputLine = scanner.nextLine();

            solution(inputLine);
        }
    }

    private static void solution(String line) {

        String[] stus = line.split(" ");
        try {
            TreeSet<Integer> c1 = new TreeSet<>();
            TreeSet<Integer> c2 = new TreeSet<>();

            boolean is1 = true;
            for (int i = 0; i < stus.length; i++) {
                String[] split = stus[i].split("/");
                String id = split[0];
                String same = split[1];
                if (i == 0) {
                    c1.add(Integer.parseInt(id));
                    continue;
                }
                if ("N".equals(same)) {
                    is1 = !is1;
                }
                (is1 ? c1 : c2).add(Integer.parseInt(id));
            }


            if (c2.size() > 0) {
                StringBuilder b1 = new StringBuilder();
                for (Integer id : c1) b1.append(id).append(" ");
                StringBuilder b2 = new StringBuilder();
                for (Integer id : c2) b2.append(id).append(" ");
                if (c1.first() < c2.first()) {
                    System.out.println(b1.toString().trim());
                    System.out.println(b2.toString().trim());
                } else {
                    System.out.println(b2.toString().trim());
                    System.out.println(b1.toString().trim());
                }
            } else {
                StringBuilder b1 = new StringBuilder();
                for (Integer id : c1) b1.append(id).append(" ");
                System.out.println(b1.toString().trim());
            }

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
