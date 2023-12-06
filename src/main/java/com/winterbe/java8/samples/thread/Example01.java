package com.winterbe.java8.samples.thread;

/**
 * @Description: Java线程优先级：Thread类的优先级常量
 *
 * 在应用程序中，如果要对线程进行调度，最直接的方式就是设置线程的优先级。优先级越高的线程获得CPU执行的机会越大，而优先级越低的线程获得CPU执
 * 行的机会越小。线程的优先级用1~10的整数来表示，数字越大优先级越高。除了可以直接使用数字表示线程的优先级外，还可以使用Thread类中提供的3个
 * 静态常量表示线程的优先级，如下所示。
 * * Thread类的优先级常量
 * Thread类的静态常量	功能描述
 * static int MAX_PRIORITY	表示线程的最高优先级，值为10
 * static int MIN_PRIORITY	表示线程的最低优先级，值为1
 * static int NORM_PRIORITY	表示线程的普通优先级，值为5
 *
 * 程序在运行期间，处于就绪状态的每个线程都有自己的优先级，例如，main线程遇有普通优先级。然而线程优先级不是固定不变的，可以通过Thread类的
 * setPriority方法进行设置，setPriority()方法中的参数newPriority接收的是1~10的整数或者Thread类的3个静态常量。下面通过一个案例演示不
 * 同优先级的两个线程在程序中的运行情况，如下所示。
 */
class MinPriority implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("优先级较低线程在输出：" + i);
        }
    }
}
class MaxPriority implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("优先级很====>高的线程在输出：" + i);
        }
    }
}

public class Example01 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MaxPriority());
        Thread t2 = new Thread(new MinPriority());
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t2.start();
        t1.start();

    }
}
