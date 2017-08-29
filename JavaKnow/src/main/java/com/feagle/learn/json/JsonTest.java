package com.feagle.learn.json;

import org.junit.Test;

/**
 * Created by Feagle on 2017/6/1.
 */
public class JsonTest {
    public static void main(String[] args) {
        int features = 0;
        System.out.println(features |= 2);
        boolean False = false;
        False |= true;
        False = False | true; // & ^ | 与 或 非
        System.out.println(False);
        int a = 1, b = 2, c = 4;//0x0001,0x0010,0x0100
        System.out.println(a |= b);// a = 0x0011 = 3
        System.out.println(b |= c);// b = 0x0110 = 6
        System.out.printf("a=%s,b=%s,c=%s", a, b, c);
    }

    @Test
    public void test_0() {
        String str = null;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d %n", 100 / 2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }
}
