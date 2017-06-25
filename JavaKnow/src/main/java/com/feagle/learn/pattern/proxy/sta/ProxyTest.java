package com.feagle.learn.pattern.proxy.sta;

/**
 * 静态代理：
 * 静态代理实现中，一个委托类对应一个代理类，代理类在编译期间就已经确定。
 * Created by Feagle on 2017/6/14.
 */
interface Subject {
    void request();
}

class RealSubject implements Subject {
    public void request(){
        System.out.println("RealSubject");
    }
}

class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void request(){
        System.out.println("begin");
        subject.request();
        System.out.println("end");
    }
}

public class ProxyTest {
    public static void main(String args[]) {
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }
}