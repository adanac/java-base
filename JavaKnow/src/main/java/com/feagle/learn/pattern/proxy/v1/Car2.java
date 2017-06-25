package com.feagle.learn.pattern.proxy.v1;

import com.feagle.learn.pattern.proxy.Car;

/**
 * 通過繼承的方式實現靜態代理
 * Created by Feagle on 2017/6/3.
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("Car2.move " + (endTime - startTime) + " ms");
    }
}
