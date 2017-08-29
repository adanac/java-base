package com.feagle.learn.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by feagle on 2017/5/24.
 */

/**
 * 演示和实际业务逻辑相关(比如读写操作)的线程不能设置成守护线程
 */
class Daemon implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public synchronized void run() {
        System.out.println("进入守护线程:" + Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出守护线程:" + Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception {
        File filename = new File("f:" + File.separator + "daemon.txt");
        OutputStream os = new FileOutputStream(filename, true);
        int count = 0;
        String content = "word";
        try {
            while (count < 999) {

                os.write(("\r\n" + content + count).getBytes());
                System.out.println("守护线程:" + Thread.currentThread().getName() + "向文件写入了" + content + count++);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) {
        System.out.println("进入主线程:" + Thread.currentThread().getName());
        Daemon daemonThread = new Daemon();
        Thread thread = new Thread(daemonThread, "守护线程daemon");
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);//键盘输入
        scanner.next();//等待用户输入,阻塞主线程,用户输入后解除阻塞主线程,主线程完成,守护也退出,导致写数据的不完整性

        System.out.println("退出主线程:" + Thread.currentThread().getName());
    }
}
