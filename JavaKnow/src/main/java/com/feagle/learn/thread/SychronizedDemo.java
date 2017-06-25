package com.feagle.learn.thread;

/**
 * Created by feagle on 2017/5/24.
 */
public class SychronizedDemo {
    //共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    //写操作
    public synchronized void write() {
        ready = true;
        number = 2;
    }

    //读操作
    public synchronized void read() {
        if (ready) {
            result = number * 2;
        }
        System.out.println("result的值:" + result);
    }

    //内部线程类
    class ReadWriteThread extends Thread {
        //根据构造方法中传入的参数来判断要读还是要写
        private boolean flag;

        public ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        SychronizedDemo sychronizedDemo = new SychronizedDemo();
        sychronizedDemo.new ReadWriteThread(true).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sychronizedDemo.new ReadWriteThread(false).start();
    }
}
