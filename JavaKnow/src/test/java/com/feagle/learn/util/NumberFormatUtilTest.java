package com.feagle.learn.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/6/20.
 */
public class NumberFormatUtilTest {


    @Test
    public void formatNumber() throws Exception {
        double count = 10001;
        String formatNumber = NumberFormatUtil.formatNumber(count);
        System.out.println("formatNumber:" + formatNumber);
    }


}