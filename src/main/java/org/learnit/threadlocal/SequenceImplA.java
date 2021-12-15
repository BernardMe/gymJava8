package org.learnit.threadlocal;

/**
 * @Description: 序列号生成器实现A
 * @Author : wangzhuo
 * @Date ： 20211215
 * @version 1.0
 */
public class SequenceImplA implements Sequence {

    private static int number = 0;

    @Override
    public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        Sequence seq = new SequenceImplA();

        ClientThread ct1 = new ClientThread(seq);
        ClientThread ct2 = new ClientThread(seq);
        ClientThread ct3 = new ClientThread(seq);

        ct1.start();
        ct2.start();
        ct3.start();
    }
}
