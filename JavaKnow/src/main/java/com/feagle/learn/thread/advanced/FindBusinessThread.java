package com.feagle.learn.thread.advanced;

/**
 * 如何定位消耗CPU最多的线程
 * Created by Feagle on 2017/6/9.
 */
public class FindBusinessThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {

                public void run() {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        Thread t = new Thread() {
            public void run() {
                int i = 0;
                while (true) {
                    i = (i++) / 100;
                }
            }
        };
        t.setName("Bussiness Thread");
        t.start();
    }
}
