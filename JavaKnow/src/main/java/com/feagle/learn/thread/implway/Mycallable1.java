package com.feagle.learn.thread.implway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 实现多线程方式三、使用ExecutorService、Callable、Future实现有返回结果的多线程(JDK5.0以后)
 * Created by Feagle on 2017/6/7.
 */
public class Mycallable1 implements Callable {
    private String taskName;

    public Mycallable1(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskName + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskName + "终止");
        return taskName + "返回运行结果,当前任务时间【" + time + "毫秒】";
    }


    /**
     * 上述代码中Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
     * public static ExecutorService newFixedThreadPool(int nThreads)
     * 创建固定数目线程的线程池。
     *
     * public static ExecutorService newCachedThreadPool()
     * 创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
     * 如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
     *
     * public static ExecutorService newSingleThreadExecutor()
     * 创建一个单线程化的Executor。
     *
     * public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
     * 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
     *
     * ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。
     * 如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
     * 总结：实现java多线程的2种方式，runable是接口，thread是类，runnable只提供一个run方法，建议使用runable实现 java多线程，不管如何，最终都需要通过thread.start()来使线程处于可运行状态。
     */
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new Mycallable1("任务" + i);
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
}
