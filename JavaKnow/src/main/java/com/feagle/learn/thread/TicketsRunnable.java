package com.feagle.learn.thread;

/**
 * Created by feagle on 2017/5/24.
 */

/**
 * 应用Runnable方式模拟卖票
 */
class MyThread2 implements Runnable {

    private String name;
    private int tickCount = 5;


    public void run() {
        while (tickCount > 0) {
            tickCount--;
            System.out.println(Thread.currentThread().getName() + "卖了1张票,剩余票数" + tickCount);
        }
    }
}

public class TicketsRunnable {

    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread t1 = new Thread(mt, "窗口1");
        Thread t2 = new Thread(mt, "窗口2");
        Thread t3 = new Thread(mt, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
