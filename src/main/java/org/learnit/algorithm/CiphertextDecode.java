package org.learnit.algorithm;

import java.util.Scanner;

/**
 * @Description 密码解密
 * 给定一段“密文”字符串 s，其中字符都是经过“密码本”映射的，现需要将“密文”解密并输出。
 *
 * 映射的规则（'a' ~ 'i'）分别用（'1' ~ '9'）表示；（'j' ~ 'z'）分别用（"10*" ~ "26*"）表示。
 * 约束：映射始终唯一。
 *
 * 输入描述
 * “密文”字符串
 * 输出描述
 * 明文字符串
 * 备注
 * 翻译后的文本长度在100以内
 *
 * 用例1
 * 输入
 * 20*19*20*
 * 输出
 * tst
 */
public class CiphertextDecode {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String m = scanner.nextLine();

            String rest = solution(m.trim());
            System.out.println(rest);

        }
    }

    private static String solution(String s) {

        s = s.replace("10*", "j");
        s = s.replace("11*", "k");
        s = s.replace("12*", "l");
        s = s.replace("13*", "m");
        s = s.replace("14*", "n");
        s = s.replace("15*", "o");
        s = s.replace("16*", "p");
        s = s.replace("17*", "q");
        s = s.replace("18*", "r");
        s = s.replace("19*", "s");
        s = s.replace("20*", "t");
        s = s.replace("21*", "u");
        s = s.replace("22*", "v");
        s = s.replace("23*", "w");
        s = s.replace("24*", "x");
        s = s.replace("25*", "y");
        s = s.replace("26*", "z");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result = result.append(getValue(s.charAt(i)));
        }
        return result.toString();
    }

    private static String getValue(char s) {

        switch (s) {
            case '1': return "a";
            case '2': return "b";
            case '3': return "c";
            case '4': return "d";
            case '5': return "e";
            case '6': return "f";
            case '7': return "g";
            case '8': return "h";
            case '9': return "i";
            default: return String.valueOf(s);
        }
    }
}