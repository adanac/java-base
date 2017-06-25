package com.feagle.learn.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 2017/5/18.
 */
public class CancelTest {
    public static void main(String[] args) throws InterruptedException {
        //创建timer实例
        Timer timer = new Timer();
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");
        //获取开始时间
        Date startTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println("start time is:" + sdf.format(startTime));
        //purge,从队列中移除的任务数
        System.out.println("current canceled task number is:" + timer.purge());
        timer.schedule(task1, 3000L, 2000L);
        timer.schedule(task2, 1000L, 2000L);
//        休眠5秒钟
        Thread.sleep(5000L);

        Date cancelTime = new Date();
        System.out.println("cancel time is:" + sdf.format(cancelTime));

//        取消所有任务
//        timer.cancel();
//        System.out.println("tasks all canceled!");

        //取消其中一个task
        task2.cancel();
        System.out.println("current canceled task number is:" + timer.purge());
    }
}
