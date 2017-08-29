package com.feagle.learn.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/7/16.
 */
public class Md5UtilTest {
    @Test
    public void MD5() throws Exception {
        System.out.println(Md5Util.MD5("20121221"));
        System.out.println(Md5Util.MD5("加密"));
    }

}