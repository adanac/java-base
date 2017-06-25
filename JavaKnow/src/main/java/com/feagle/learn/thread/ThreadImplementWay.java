package com.feagle.learn.thread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Java多线程实现方式主要有三种：
 * - 继承Thread类（无返回值）
 * - 实现Runnable接口（无返回值）
 * - 使用ExecutorService、Callable、Future实现有返回结果的多线程。
 * Created by Feagle on 2017/6/7.
 */
public class ThreadImplementWay {


    /**
     * 方式一、继承Thread类
     */
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("通过继承Thread类的方式实现多线程!");
        }
    }

    public void testWay1(){
        MyThread myThread = new MyThread();
        myThread.start();//开启线程
    }

    /**
     * 方式二、实现Runnable接口
     */
    class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("通过实现Runnable接口的方式实现多线程");
        }
    }

    public void testWay2(){
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }

    /**
     * 方式三、使用ExecutorService/Callable/Future实现有返回结果的多线程
     */
    class MyCallable implements Callable<Object> {
        private String taskName;

        public MyCallable(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public Object call() throws Exception {
            System.out.println("taskName:" + taskName + " 启动");
            long start = new Date().getTime();

            Thread.sleep(2000L);
            long end = new Date().getTime();

            System.out.println("taskName:" + taskName + " 终止");
            return taskName + "返回运行结果: 执行时间为" + (end - start) + "ms";
        }
    }

    /**
     * 实现Callable接口通过FutureTask包装器来创建Thread线程
     * @param args
     */
    public class SomeCallable<V>  implements Callable<V> {

        @Override
        public V call() throws Exception {
            System.out.println("i'm somecallable in call()");
            return null;
        }

    }

    public void testWay4() throws Exception {
        SomeCallable callable = new SomeCallable<>();
        callable.call();
    }



    public static void main(String[] args) throws Exception {
        ThreadImplementWay threadImplementWay = new ThreadImplementWay();
//        threadImplementWay.testWay1();//测试方式一
//        threadImplementWay.testWay2();//测试方式二
        threadImplementWay.testWay4();
    }

}
