package com.feagle.learn.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/18.
 */
public class MyTimerTask extends TimerTask {
    private String name;
    private Integer count = 0;//计数器

    public MyTimerTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (count < 3) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            System.out.println("Current exec time is " + sdf.format(calendar.getTime()));
            System.out.println("Current exec name is " + name);
            count++;
        } else {
            cancel();
            System.out.println("Task cancel!");
        }
    }
}
