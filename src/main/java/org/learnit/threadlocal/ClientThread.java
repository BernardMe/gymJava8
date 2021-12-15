package org.learnit.threadlocal;

/**
 * @Description: 自定义线程类
 * @Author : wangzhuo
 * @Date ： 20211215
 * @version 1.0
 */
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " => " +
                    sequence.getNumber());
        }
    }
}
