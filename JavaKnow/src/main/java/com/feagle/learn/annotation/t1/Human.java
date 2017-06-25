package com.feagle.learn.annotation.t1;

/**
 * 使用自定义注解的类
 * Created by Feagle on 2017/6/2.
 */
@Description(desc="this is ElementType.TYPE",author="allen",age=21)
public class Human {
    @Description(desc = "this is ElementType.METHOD",author = "tony", age = 19)
    public void run(){
        System.out.println("i can run...");
    }
}
