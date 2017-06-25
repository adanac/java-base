package com.feagle.learn.reflect.t1;

import org.junit.Test;

/**
 * Created by Feagle on 2017/6/2.
 */
public class OfficeBetter {

    public void pro(String className) {
        try {
            //动态加载类，在运行时加载
            Class<?> aClass = Class.forName(className);
            //通过类类型，创建此类对象
            OfficeAble oa = (OfficeAble) aClass.newInstance();
            oa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        String className = "com.feagle.learn.reflect.t1.Excel";
        new OfficeBetter().pro(className);
    }
}
