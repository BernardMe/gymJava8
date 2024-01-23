package com.winterbe.java8.samples.concurrent;

public class AppleEater implements Runnable {

    public Integer num = 50;

    @Override
    public void run() {
        while (num > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "吃掉了编号=" + num-- + "的苹果");
                }
            }
        }
    }
}
