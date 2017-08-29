package com.feagle.learn.json;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.feagle.learn.util.Md5Util;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/7/16.
 */
public class FastJsonMethodUtilTest {
    public static final Logger logger = LoggerFactory.getLogger(FastJsonMethodUtil.class);

    @Test
    public void toJson() throws Exception {
        String s = FastJsonMethodUtil.toJson(new double[] { 4, 55 });
        logger.debug(s);
        logger.debug(Md5Util.MD5("11111"));
    }

    @Test
    public void toJson1() throws Exception {
        MySerializeFilter filter = new MySerializeFilter();
        filter.setFilterId("f_001");
        filter.setFilterName("myfilter_name_1");


        Hobby hobby = new Hobby();
        hobby.setHobbyId(101);
        hobby.setHobbyName("吃饭");

        String s = FastJsonMethodUtil.toJson(hobby,filter);
        logger.debug(s);
        logger.debug(Md5Util.MD5("11111"));

    }

    @Test
    public void toJsonCustom() throws Exception {
    }

    @Test
    public void fromJson() throws Exception {
    }

    @Test
    public void fromJson1() throws Exception {
    }

    @Test
    public void jsonToList() throws Exception {
    }

    @Test
    public void jsonToList1() throws Exception {
    }

    @Test
    public void xNodes() throws Exception {
    }

    @Test
    public void xNodesForTV() throws Exception {
    }

}

class MySerializeFilter implements SerializeFilter{
    private String filterId;
    private String filterName;

    public MySerializeFilter() {
    }

    public MySerializeFilter(String filterId, String filterName) {
        this.filterId = filterId;
        this.filterName = filterName;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }
}