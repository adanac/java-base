package com.feagle.learn.thread.implway;

/**
 * 实现多线程方式一、继承Thread类，重写父类run()方法
 * Created by Feagle on 2017/6/7.
 */
public class Mythread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是线程" + this.getId() + "->" + this.getName() + "->" + this.getState() + "->" + i);
        }
    }


    /**
     * 不可直接调用run方法：
     * run（）方法只是普通的方法，是顺序执行的，即th1.run（）执行完成后才执行th2.run（），这样写只用一个主线程。
     * 多线程就失去了意义，所以应该用start（）方法来启动线程,start()方法会自动调用run（）方法
     */
    public static void wrong() {
        Mythread1 th1 = new Mythread1();
        Mythread1 th2 = new Mythread1();
        th1.run();
        th2.run();
    }

    /**
     * 通过start()方法启动一个新的线程。
     * 这样不管th1.start()调用的run()方法是否执行完，都继续执行th2.start()。
     * 如果下面有别的代码也同样不需要等待th2.start()执行完成，而继续执行。（输出的线程id是无规则交替输出的）
     */
    public static void right() {
        Mythread1 th1 = new Mythread1();
        Mythread1 th2 = new Mythread1();
        th1.start();
        th2.start();
    }

    public static void main(String[] args) {
        wrong();//顺序打印
//        right();//交替打印
    }
}
