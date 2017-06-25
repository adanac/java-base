package com.feagle.learn.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by feagle on 2017/5/25.
 */

/**
 * StringJoiner 的底层实现就是 StringBuilder —— Java8 将 使用分隔符连接多个字符串 这一功能进行封装
 */
public class StringDemo {

    /**
     * Java8 之前我们的第一反应是使用 StringBuilder
     * @param list
     * @param delimiter
     * @return
     */
    @Test
    public void formatList(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        System.out.println("使用 StringBuilder：");
        String format = formatList(list, ", ");
        System.out.println(format);
    }

    public String formatList(List<String> list, String delimiter) {
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str).append(delimiter);
        }
        result.delete(result.length() - delimiter.length(), result.length()); // 删除末尾多余的 delimiter
        return result.toString();
    }


    /**
     * JDK 1.8 时，添加了一个新的用于字符串连接的类，专门用于这种需要 分隔符 的场合，那就是 StringJoiner
     */
    @Test
    public void formatList2(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        System.out.println("使用 StringJoiner：");
        String format = formatList2(list, ", ");
        System.out.println(format);
    }
    public static String formatList2(List<String> list, String delimiter) {
        StringJoiner result = new StringJoiner(delimiter);
        for (String str : list) {
            result.add(str);
        }
        return result.toString();
    }

    /**
     * JDK1.8 为 String 类添加了一个新的静态方法,但它不能指定前缀和后缀
     */
    @Test
    public void formatList3(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        System.out.println("使用 String.join()：");
        String format = formatList3(list, ", ");
        System.out.println(format);
    }
    public static String formatList3(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    /**
     * StringJoiner 除了指定 分隔符 的构造方法，还有一个可以指定 分隔符、前缀和后缀 的构造方法
     */
    @Test
    public void formatList4(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        System.out.println("使用 StringJoiner，带前缀和后缀：");
        String format = formatList4(list, ", ", "{ ", " }");
        System.out.println(format);
    }
    public static String formatList4(
            List<String> list, String delimiter, String prefix, String suffix) {

        StringJoiner result = new StringJoiner(delimiter, prefix, suffix);
        for (String str : list) {
            result.add(str);
        }
        return result.toString();
    }

    /**
     * Java8 对于字符串集合的连接操作提供了一个专门的流式 API，即 Collectors.joining 函数:
     * 1、无参的 joining() 方法，即不存在连接符（底层实现为 StringBuilder）
     * 2、joining(CharSequence delimiter) 方法，即分隔符为 delimiter（底层实现为 StringJoiner）
     * 3、joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)方法，即分隔符为 delimiter，前缀为 prefix，后缀为 suffix（底层实现为 StringJoiner）
     */
    @Test
    public void formatList5(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        System.out.println("使用 Collectors.joining：");
        String format = formatList5(list, ", ", "{ ", " }");
        System.out.println(format);
    }

    public static String formatList5(
            List<String> list, String delimiter, String prefix, String suffix) {

        return list.stream().collect(Collectors.joining(delimiter, prefix, suffix));
    }


}
