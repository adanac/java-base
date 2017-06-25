package com.feagle.learn.annotation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Feagle on 2017/5/31.
 */
public class ReturnQueryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void query() throws Exception {
        User u1 = new User();
        u1.setId(9);  //查询id为9的用户

        User u2 = new User();
        u2.setUserName("JTZeng");   //模糊查询用户名为JTZeng的用户
        u2.setAge(21);

        User u3 = new User();
        u3.setEmail("123@163.com,123@qq.com");  //查询邮箱有任意一个的用户

        String sql1 = ReturnQuery.query(u1);    //查询id为9的用户
        String sql2 = ReturnQuery.query(u2);    //查询用户名为JTZeng和年龄为21的用户
        String sql3 = ReturnQuery.query(u3);    //查询邮箱中有任意一个的用户

        logger.info("sql1={}",sql1);
        logger.info("sql2={}",sql2);
        logger.info("sql3={}",sql3);
    }

}