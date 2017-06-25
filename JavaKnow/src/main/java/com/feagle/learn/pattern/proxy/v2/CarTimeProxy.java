package com.feagle.learn.pattern.proxy.v2;

/**
 * Created by Feagle on 2017/6/4.
 */
public class CarTimeProxy implements Moveable {
    private Moveable m;

    public CarTimeProxy(Moveable m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        m.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车行驶时间: " + (endtime - starttime) + " ms");
    }
}
