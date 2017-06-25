package com.feagle.learn.thread.implway;

/**
 * 实现多线程方式二、实现Runnable接口
 * Created by Feagle on 2017/6/7.
 */
public class Mythread2 implements Runnable {
    public String ThreadName;

    public Mythread2(String tName) {
        ThreadName = tName;
    }


    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(ThreadName + "->" + i);
        }
    }


    /**
     * 和Thread的run方法一样Runnable的run只是普通方法，
     * 在main方法中th2.run（）必须等待th1.run（）执行完成后才能执行，程序只用一个线程。
     * 要实现多线程，也要通过Thread的start（）方法（注:runnable是没有start方法）
     */
    public static void wrong() {
        Mythread2 th1 = new Mythread2("线程A");
        Mythread2 th2 = new Mythread2("线程B");
        th1.run();
        th2.run();
    }

    public static void right() {
        Mythread2 myth1 = new Mythread2("线程A");
        Mythread2 myth2 = new Mythread2("线程B");
        Thread t1 = new Thread(myth1);
        Thread t2 = new Thread((myth2));
        t1.start();
        t2.start();
    }


    public static void main(String[] args) {
//        wrong();
        right();
    }
}
