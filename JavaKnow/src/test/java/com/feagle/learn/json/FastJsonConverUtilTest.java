package com.feagle.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.feagle.learn.dto.MyGenericList;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/7/16.
 */
public class FastJsonConverUtilTest {
    @Test
    public void json2List() throws Exception {
        String json = "[{\"name\":\"allen\",\"id\":1},{\"name\":\"scott\",\"id\":2}]";
        List<Object> userList = FastJsonConverUtil.json2List(json, User.class);
        System.out.println(userList);//[User [id=1, name=allen, status=null, createTime=null, hobbyList=null], User [id=2, name=scott, status=null, createTime=null, hobbyList=null]]
    }

    @Test
    public void object2JSONObject() throws Exception {
        User user = new User();
        user.setId(1);
        user.setStatus(1L);
        JSONObject jsonObject = FastJsonConverUtil.object2JSONObject(user);
        System.out.println(jsonObject);//{"st":1,"id":1}
    }

    @Test
    public void json2JSONObject() throws Exception {
        String json = "{\"name\":\"adanac\"}";
        JSONObject jsonObject = FastJsonConverUtil.json2JSONObject(json);
        System.out.println(jsonObject.get("name"));
    }

    @Test
    public void jsonStr2Map() throws Exception {
        String jsonStr = "{id:100,list:[{a:1},{a:2}]";
        Map<String, Object> map = FastJsonConverUtil.jsonStr2Map(jsonStr);
        System.out.println(map);
        Integer id = MapUtils.getInteger(map, "id");
        System.out.println("id=" + id);
        List<JSONObject> list = (List<JSONObject>) MapUtils.getObject(map, "list");
        for (JSONObject data : list) {
            System.out.println(data.get("a"));
        }
    }

    @Test
    public void map2Json() throws Exception {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setId(1);
        user.setStatus(1L);
        map.put("user1", user);
        user = new User();
        user.setId(2);
        user.setStatus(2L);
        map.put("user2", user);
        String json = FastJsonConverUtil.map2Json(map);
        System.out.println(json);

    }

    @Test
    public void list2Json() throws Exception {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setStatus(i + 101L);
            userList.add(user);
        }
        String json = FastJsonConverUtil.list2Json(userList);
        System.out.println(json);//[{"id":1,"st":101},{"id":2,"st":102}]
    }

    @Test
    public void json2Array() throws Exception {
        String json = "[\"bill\",\"green\",\"maks\",\"jim\"]";
        JSONArray objects = FastJsonConverUtil.json2Array(json);
        System.out.println(JSON.toJSONString(objects));//["bill","green","maks","jim"]

        json = "[{\"id\":101,\"st\":1},{\"id\":102,\"st\":2}]";
        objects = FastJsonConverUtil.json2Array(json);
        System.out.println(JSON.toJSONString(objects));
        System.out.println("JSONArray==>" + objects);
    }

    @Test
    public void array2JSONString() throws Exception {
        String[] arr = {"bill", "green", "maks", "jim"};
        String jsonText = JSON.toJSONString(arr);
        System.out.println("array2Json()方法：jsonText==" + jsonText);

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(101);
        user.setName("用户1");
        user.setStatus(1L);
        users.add(user);


        user = new User();
        user.setId(102);
        user.setName("用户2");
        user.setStatus(2L);
        users.add(user);
        jsonText = JSON.toJSONString(users);
        System.out.println("array2Json()方法：jsonText==" + jsonText);
    }


    @Test
    public void bean2JSONString() throws Exception {
    }

    @Test
    public void json2Object() throws Exception {
        String json = "{\"id\":101,\"st\":1}";
        User user = (User) FastJsonConverUtil.json2Object(json, User.class);
        System.out.println(user.toString());
    }

    @Test
    public void jSONString2Bean1() throws Exception {
    }

    @Test
    public void beanArray2JSONString() throws Exception {
    }

    @Test
    public void beanArray2JSONString1() throws Exception {
    }

    @Test
    public void jsonString2BeanList() throws Exception {
    }


}