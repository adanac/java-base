package com.feagle.learn.reflect;

import org.junit.Test;

/**
 * Created by Feagle on 2017/6/2.
 */
public class MethodDemo3 {
    @Test
    public void test(){
        String s = "hello";

        ClassUtil.printClassMethodMessage(s);
    }
}
