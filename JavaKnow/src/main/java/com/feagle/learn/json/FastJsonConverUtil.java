package com.feagle.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.feagle.learn.dto.MyGenericList;

import java.util.List;
import java.util.Map;

/**
 * Created by Feagle on 2017/7/16.
 */
public class FastJsonConverUtil {

    /**
     * 对象转json字符串
     *
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json字符串转对象
     *
     * @param jsonString
     * @return
     */
    public static Object jsonObject(String jsonString) {
        return JSON.parseObject(jsonString);
    }

    /**
     * json字符串转指定对象
     * Json文本信息中的键的名称必须和JavaBean中的字段名称一样！键中没有的在这个JavaBean中就显示为null
     * @param jsonString
     * @param clazz 指定对象类型
     * @return
     */
    public static Object json2Object(String jsonString, Class clazz) {
        return JSON.parseObject(jsonString, clazz);
    }


    /**
     * 将对象数组转为json字符串
     *
     * @param objects
     * @return
     */
    public String objectArray2Json(Object[] objects) {
        return JSON.toJSONString(objects);
    }

    /**
     * 将json字符串转为对象数组
     *
     * @param json
     * @return
     */
    public static List<Object> json2ObjectList(String json) {
        List<Object> objects = JSON.parseArray(json);
        return objects;
    }


    /**
     * 数组转json字符串
     */
    public static String array2Json(Object[] objects) {
        return JSON.toJSONString(objects);

    }

    /**
     * json格式字符串转数组
     *
     * @param jsonString
     * @return
     */
    public static JSONArray json2Array(String jsonString) {
        return JSON.parseArray(jsonString);
    }

    /**
     * List集合转json字符串
     *
     * @param dataList
     * @return
     */
    public static String list2Json(List dataList) {
        return JSON.toJSONString(dataList);
    }

    /**
     * map转json字符串
     *
     * @param map 参数为map类型
     * @return
     */
    public static String map2Json(Map map) {
        return JSON.toJSONString(map);
    }


    /**
     * json字符串转map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> jsonStr2Map(String jsonStr) {

        Map<String, Object> map = JSON.parseObject(
                jsonStr, new TypeReference<Map<String, Object>>() {
                });

        return map;
    }

    /**
     * json文本数据信息转换为JSONObject对象，然后利用键值对的方式获取信息
     * @param json
     * @return
     */
    public static JSONObject json2JSONObject(String json){
        return JSON.parseObject(json);
    }


    /**
     * 将JavaBean转换为JSON对象
     * @param object
     * @return
     */
    public static JSONObject object2JSONObject(Object object){
        return (JSONObject) JSON.toJSON(object);
    }

    /**
     * 将JSON文本转换为JavaBean的集合
     * @param json
     * @param clazz
     * @return
     */
    public static List<Object> json2List(String json,Class clazz){
        List list = JSON.parseArray(json, clazz);
        return list;
    }
}
