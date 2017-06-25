package com.feagle.learn.util;

/**
 * Created by Feagle on 2017/6/20.
 */
public class NumberFormatUtil {
    /**
     * 将数值向上取整，如：10002 -> 1.1万
     * @param count
     * @return
     */
    public static String formatNumber(double count) {
        if (count < 10000) {//小于1万直接返回
            return Integer.toString((int) count);
        }
        if (count > 100000) {//大于10万以万为单位
            return Integer.toString((int) Math.ceil(count / 10000)) + "万";
        }
        return Double.toString(Math.ceil(count / 1000) / 10) + "万";
    }
}
