package org.learnit.essential;

public class TestStatic01 {
    static {
        _i = 20;
    }
    public static int _i = 10;

    public static void main(String[] args) {
        System.out.println(_i);
    }
}
