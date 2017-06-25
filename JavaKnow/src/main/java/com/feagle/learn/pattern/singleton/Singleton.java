package com.feagle.learn.pattern.singleton;

/**
 * 单例模式：整个程序只有一个对象，推荐使用饿汉模式，简单，安全
 * 饿汉模式（程序在加载类的时候就会实例化单例对象，体现在第二步）
 * Created by Feagle on 2017/6/3.
 */
public class Singleton {
    /*1.将默认构造方法私有化，不允许外界使用构造方法创建实例*/
    private Singleton() {};
    /*2.实例化一个静态的 对象，整个程序只使用此类该对象*/
    private static final Singleton instance = new Singleton();
    /*3.提供一个方法。供外界获取实例*/
    public static Singleton getInstance(){
        return instance;
    }
}