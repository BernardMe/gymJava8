package org.learnit.oop;

/**
 * @Description :
 * @Title Animal
 * @author :  wangzhuo
 * @Creation Date:  20210323
 */
public class Animal {
    public String name = "Animal：动物";
    public static String staticName = "Animal：可爱的动物";
    public void eat() {
        System.out.println("Animal：吃饭");
    }
    public static void staticEat() {
        System.out.println("Animal：动物在吃饭");
    }
}
