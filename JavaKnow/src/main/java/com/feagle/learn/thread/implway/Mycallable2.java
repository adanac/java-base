package com.feagle.learn.thread.implway;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Feagle on 2017/6/7.
 */
public class Mycallable2 implements Callable {
    private String taskName;

    public Mycallable2(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public Object call() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(taskName + " 开始...");
        Thread.sleep(2000L);
        System.out.println(taskName + " 结束...");
        return taskName + " 执行了" + (System.currentTimeMillis() - start) + "ms";

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 5;
        ExecutorService pool =
                Executors.newFixedThreadPool(taskSize);//创建一个线程池

        List<Future> resultList = new ArrayList<>();
        //创建多个有返回值的任务
        for (int i=0;i<taskSize;i++) {
            //执行任务，并获取Future对象
            Future future = pool.submit(new Mycallable2("任务->" + i));
            resultList.add(future);
        }
        //关闭线程池
        pool.shutdown();

        //遍历返回结果
        for (Future f: resultList){
            System.out.println(">>>"+f.get());
        }



    }
}
