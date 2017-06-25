package com.feagle.learn.pattern.proxy;

import com.feagle.learn.pattern.proxy.Car;
import com.feagle.learn.pattern.proxy.Moveable;
import com.feagle.learn.pattern.proxy.v3.TimeHandler;
import com.feagle.learn.pattern.proxy.v4.CglibProxy;
import com.feagle.learn.pattern.proxy.v4.Train;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Feagle on 2017/6/3.
 */
public class MoveableTest {
    @Test
    public void move() throws Exception {
//        Car car = new Car();
//        car.move();

        //測試通過繼承方式實現靜態代理
//        Moveable car2 = new Car2();
//        car2.move();
        //測試通過聚合方式實現靜態代理
//        Car car = new Car();
//        Moveable car3 = new Car3(car);
//        car3.move();

    }

    @Test
    public void testv2() throws Exception {
//        Car car = new Car();
//        CarTimeProxy ctp = new CarTimeProxy(car);
//        CarLogProxy clp = new CarLogProxy(ctp);
//        clp.move();
    }

    /**
     * JDK动态代理测试类
     */
    @Test
    public void testv3() {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /**
         * loader  类加载器
         * interfaces  实现接口
         * h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), h);
        m.move();
    }

    @Test
    public void testv4(){
        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);
        t.move();
    }

}