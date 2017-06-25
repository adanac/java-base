package com.feagle.learn.thread;

/**
 * Created by feagle on 2017/5/24.
 */

/**
 * 应用thread模拟卖票,总共卖了15张票,资源(票)没有在多个线程中共享
 */
class MyThread1 extends Thread{
    private String name;//线程的名字
    private int tickCount =5;//共有5张票

    public MyThread1(String name) {
        this.name= name;
    }

    public void run(){
        while (tickCount>0) {
            tickCount--;//还有票就卖一张
            System.out.println(name+"卖票1张,剩余票数"+tickCount);
        }
    }
}
public class TicketsThread {
    public static void main(String[] args) {
        MyThread1 th1 = new MyThread1("窗口1");
        MyThread1 th2 = new MyThread1("窗口2");
        MyThread1 th3 = new MyThread1("窗口3");
        th1.start();;
        th2.start();;
        th3.start();;
    }
}
