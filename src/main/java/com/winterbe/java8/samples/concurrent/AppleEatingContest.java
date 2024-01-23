package com.winterbe.java8.samples.concurrent;

public class AppleEatingContest {


    public static void main(String[] args) {
        Runnable rn = new AppleEater();

        Thread t1 = new Thread(rn, "吃货A");
        Thread t2 = new Thread(rn, "吃货B");
        Thread t3 = new Thread(rn, "吃货C");

        t1.start();
        t2.start();
        t3.start();
    }


}
