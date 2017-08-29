package com.feagle.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.List;

/**
 * Created by Feagle on 2017/7/16.
 */
public class FastJsonMethodUtil {

    public static SerializeConfig mapping = new SerializeConfig();

    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer(DEFAULT_DATE_FORMAT));
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
    }

    public static <T> String toJson(T t) {
        return JSON.toJSONString(t);
    }

    public static <T> String toJson(T t, SerializeFilter filter) {
        return JSON.toJSONString(t, filter);
    }

    public static <T> String toJsonCustom(T t) {
        return JSON.toJSONString(t, mapping, SerializerFeature.WriteMapNullValue);
    }

    public static <T> T fromJson(String json, Class<T> t) {
        return (T) JSON.parseObject(json, t);
    }

    public static JSONObject fromJson(String json) {
        return JSON.parseObject(json);
    }

    public static <T> List<T> jsonToList(String json, Class<T> t) {
        return (List<T>) JSON.parseArray(json, t);
    }

    public static JSONArray jsonToList(String json) {
        return JSON.parseArray(json);
    }

    /**
     * @param jsonObj 从jsonobject 目录节点
     * @param dirTree 层次关系
     * @return
     */
    public static Object xNodes(JSONObject jsonObj, String... dirTree) {
        JSONObject deepJsonObj = jsonObj;
        int last = dirTree.length - 1;
        for (int i = 0; i < dirTree.length; i++) {
            if (deepJsonObj == null) {
                return null;
            }
            String node = dirTree[i];
            if (i == last) {
                return deepJsonObj.get(node);
            }
            deepJsonObj = deepJsonObj.getJSONObject(node);
        }
        return null;
    }

    /**
     * @param jsonObj 从jsonobject 目录节点,最后一层自动增加“Text_Value”
     * @param dirTree 层次关系
     * @return
     */
    public static Object xNodesForTV(JSONObject jsonObj, String... dirTree) {
        JSONObject testJsonObj = (JSONObject) xNodes(jsonObj, dirTree);
        if (testJsonObj != null) {
            return testJsonObj.get("Text_Value");
        }
        return null;
    }

}


class User {
    private int id;
    private String name;
    private Long status;
    private Date createTime;
    private List<Hobby> hobbyList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JSONField(serialize = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(name = "st")
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", status=" + status + ", createTime=" + createTime
                + ", hobbyList=" + hobbyList + "]";
    }

}

class Hobby {
    private int hobbyId;
    private String hobbyName;

    public Hobby() {
    }

    public int getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(int hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

}