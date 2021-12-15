package org.learnit.threadlocal;

/**
 * @Description: 序列号生成器实现B
 * @Author : wangzhuo
 * @Date ： 20211215
 * @version 1.0
 */
public class SequenceImplB implements Sequence {

    // 尝试使用ThreadLocal线程局部变量
    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence seq = new SequenceImplB();

        ClientThread ct1 = new ClientThread(seq);
        ClientThread ct2 = new ClientThread(seq);
        ClientThread ct3 = new ClientThread(seq);

        ct1.start();
        ct2.start();
        ct3.start();
    }
}
