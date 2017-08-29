package com.feagle.learn;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试一个数是否是2的次方
 * Created by Feagle on 2017/6/12.
 */
public class MathTest {

    @Test
    public void testFloat() {
        Assert.assertTrue(3 * 0.1 == 0.3);// false
    }

    @Test
    public void test0() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ":" + judgeNumber(2));
        }
    }

    @Test
    public void test1() {
        for (int i = 0; i < 10000; i++) {
            if (judgeNumber(i)) {
                System.out.println(i + ":" + judgeNumber(i));
            }
        }
    }

    public boolean nCF3(int n) {
        boolean boo = true;
        String s = Integer.toBinaryString(n);
        byte[] b = s.getBytes();


        for (int i = 1; i < b.length; i++) {
            if (b[i] != 48) {
                boo = false;
                break;
            }
        }
        return boo;

    }

    public boolean judgeNumber(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        boolean flag = false;
        while (true) {
            int j = num % 2;
            num = num / 2;
            if (j == 1) {
                flag = false;
                break;
            }

            if (num == 2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean nCF1(int i) {
        return (i > 0) && ((i & (i - 1)) == 0);
    }

    public static boolean nCF2(int i) {
        if (i == 0) {
            return false;
        }
        while (i % 2 == 0) {
            i = i / 2;
        }
        return i == 1 ? true : false;
    }
}
