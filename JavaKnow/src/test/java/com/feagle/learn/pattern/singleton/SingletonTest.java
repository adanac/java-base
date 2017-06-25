package com.feagle.learn.pattern.singleton;

import org.junit.Test;

/**
 * Created by Feagle on 2017/6/3.
 */
public class SingletonTest {
    @Test
    public void test(){
        //饿汉模式
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if(s1 == s2){
            System.out.println("yes,是同一个实例");
        }else {
            System.out.println("no,不是同一个实例");
        }

        //懒汉模式
        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        if (s3 == s4) {
            System.out.println("yes,是同一个实例");
        } else {
            System.out.println("no,不是同一个实例");
        }
    }

}