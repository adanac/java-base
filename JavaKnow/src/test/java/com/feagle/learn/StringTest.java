package com.feagle.learn;

import org.junit.Test;

/**
 * Created by Feagle on 2017/6/12.
 */
public class StringTest {

    @Test
    public  void test1() {
        String str = "123";
        str = changeStr(str);
        System.out.println(str);//welcome
    }

    @Test
    public void test2(){
        String str = "4556";
        changeStr(str);
        System.out.println(str);//4556
    }

    private static String changeStr(String str) {
        str = "welcome";
        return str;
    }
}
