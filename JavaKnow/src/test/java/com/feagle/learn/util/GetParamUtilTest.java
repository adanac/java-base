package com.feagle.learn.util;

import com.feagle.learn.dto.Demo;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/7/2.
 */
public class GetParamUtilTest {
    @Test
    public void getMethodParamNames() throws Exception {
        Map<String, List<String>> methodParamNames = GetParamUtil.getMethodParamNames("com.feagle.learn.dto.Demo");

        System.out.println("-----------------------");
        for (Map.Entry<String, List<String>> entry :
                methodParamNames.entrySet()) {
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }
    }

}