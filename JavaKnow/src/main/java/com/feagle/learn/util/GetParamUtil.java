package com.feagle.learn.util;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取类的方法参数工具类
 * Created by Feagle on 2017/7/1.
 */
public class GetParamUtil {

    private static final LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();


    /**
     * 通过反射获取所有方法的参数名列表
     *
     * @return
     */
    public static Map<String, List<String>> getMethodParamNames(String className) {
        Map<String, List<String>> paramMap = new HashMap<>();
        Class<?> aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = aClass.getMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append("方法：" + method.getName() + " ");
            String[] parameterNames = getParameterNames(method);
            if (parameterNames == null || parameterNames.length < 1) {
                sb.append("无参");
            } else {
                sb.append("[");
                List<String> paramList = new ArrayList<>();
                for (int i = 0; i < parameterNames.length; i++) {
                    sb.append(parameterNames[i]);
                    sb.append(",");
                    paramList.add(parameterNames[i]);
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                paramMap.put(method.getName(), paramList);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        return paramMap;
    }


    /**
     * 获取方法所有参数名
     *
     * @param method
     * @return
     */
    public static String[] getParameterNames(Method method) {
        return parameterNameDiscoverer.getParameterNames(method);
    }

}
