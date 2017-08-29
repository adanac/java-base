package com.feagle.learn.reflect;

import org.junit.Test;

public class ClassDemo2{
    public static void main(String[] args) {
        Class c1 = int.class;//int的类类型
        Class c2 = String.class;//String的类类型
        System.out.println(c1.getName());
        System.out.println(c2.getName());
    }

    @Test
    public void test1(){
        ClassDemo2 cd = new ClassDemo2();
        Class cdClass = cd.getClass();
        System.out.println("getName():"+cdClass.getClass().getName());
        System.out.println("getSimpleName():"+cdClass.getSimpleName());
    }
}