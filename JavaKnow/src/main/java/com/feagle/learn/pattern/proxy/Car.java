package com.feagle.learn.pattern.proxy;

import java.util.Random;

/**
 * Created by Feagle on 2017/6/3.
 */
public class Car implements Moveable {
    public void move() {
        //实现方法
        try {
            Thread.sleep(new Random().nextInt(1000));//sleep 1000ms 以内
            System.out.println("Car.move");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
