package com.feagle.learn.pattern.proxy.v1;

import com.feagle.learn.pattern.proxy.Car;
import com.feagle.learn.pattern.proxy.Moveable;

/**
 * 通過聚合方式實現靜態代理
 * Created by Feagle on 2017/6/3.
 */
public class Car3 implements Moveable {
    private Car car;

    public Car3(Car car) {
        super();
        this.car = car;
    }

    public void move() {
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        System.out.println("Car3.move " + (endTime - startTime) + " ms");
    }
}
