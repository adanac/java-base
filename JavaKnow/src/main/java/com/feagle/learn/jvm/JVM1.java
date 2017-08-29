package com.feagle.learn.jvm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存溢出
 * Created by Feagle on 2017/7/6.
 */
public class JVM1 {
    private static Map<Long, Set<Integer>> setMap = new ConcurrentHashMap<>();
    private Logger logger = LoggerFactory.getLogger(JVM1.class);

    @Test
    public void test1() {
        final long key = 1L;
        setMap.put(key, new HashSet<>());
        for (int i = 0; i < 100; i++
                ) {
            setMap.get(key).add(i);
        }
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200000; i++) {
                    setMap.get(key).add(i);
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 200000; i < 200000 + 200000; i++) {
                    setMap.get(key).add(i);
                }
            }
        });

        a.start();
        b.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void test2(){
    }
}
