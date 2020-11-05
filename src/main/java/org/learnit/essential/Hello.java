package org.learnit.essential;

import java.lang.Class;

class MyClass1 {
    static {//静态块
        System.out.println("static block ");
    }

    {//非静态块
        System.out.println("non-static block ");
    }
}
public class Hello {
    public static void main(String[] args) {
        try {
            MyClass1 c1 = new MyClass1();

            System.out.println("hello word: " + Class.forName("org.learnit.essential.MyClass1"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
