package com.feagle.learn.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Administrator on 2017/5/18.
 */
public class MyTimer extends Timer {
    public static void main(String[] args) {
        //1.创建一个timer实例
        Timer timer = new Timer();
        //2.创建一个MyTimerTask实例
        MyTimerTask myTimerTask = new MyTimerTask("t1");
        //3.通过Timer的定时定频率调用MyTimerTask的业务逻辑，
        // 即第一次执行是在当前时间的2s后，之后每隔1s钟执行一次
//        timer.schedule(myTimerTask,2000L,1000L);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println("Current time is " + sdf.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, 3);

        /**
         * 用法1.在时间等于或超过time的时候执行且只执行一次
         */
//        myTimerTask.setName("schedule1");
//        timer.schedule(myTimerTask,calendar.getTime());

        /**
         * 用法2.在时间等于或超过time的时候首次执行task,
         * 之后每隔一定时间重复执行一次task
         */
//        myTimerTask.setName("schedule2");
//        timer.schedule(myTimerTask,calendar.getTime(),2000L);

        /**
         * 用法3.等待delay毫秒后执行且只执行一次任务
         */
//        myTimerTask.setName("schedule3");
//        timer.schedule(myTimerTask, 3000L);

        /**
         * 用法4.等待delay毫秒后首次执行任务,
         * 之后每隔delay毫秒后重复执行一次task
         *
         */
        myTimerTask.setName("schedule4");
        timer.schedule(myTimerTask, 1000L);
        System.out.println("schedule time is :"+sdf.format(myTimerTask.scheduledExecutionTime()));

    /********** scheduleAtFixedRate **********/
        /**
         * 用法1.时间等于或超过timer时首次执行task,
         * 之后 每隔period毫秒重复执行一次任务
         */
//        myTimerTask.setName("scheduleAtFixedRate1");
//        timer.scheduleAtFixedRate(myTimerTask,calendar.getTime(),1000L);
        /**
         * 用法等待delay毫秒后首次执行task,
         * 之后 每隔period毫秒重复执行一次任务
         */
//        myTimerTask.setName("scheduleAtFixedRate2");
//        timer.scheduleAtFixedRate(myTimerTask,2000L,1000L);
    }
}
