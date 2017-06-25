package com.feagle.learn.thread.state;

/**
 * join():
 * 等待调用join方法的线程结束，再继续执行。
 * 如：t.join();//主要用于等待t线程运行结束，若无此句，main则会执行完毕，导致结果不可预测
 * Created by Feagle on 2017/6/7.
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i +"次执行！");
            if (i > 2)try {
                //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }
}