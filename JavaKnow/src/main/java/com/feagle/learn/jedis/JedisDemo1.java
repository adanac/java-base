package com.feagle.learn.jedis;

/**
 * Created by Administrator on 2017/5/22.
 */

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 */
public class JedisDemo1 {
    /**
     * 单实例方式
     */
    @Test
    public void demo1() {
        //1.设置IP地址和端口
        Jedis jedis = new Jedis("192.168.56.104", 6379);
        //权限认证
        jedis.auth("123456");
        //2.保存数据
        jedis.set("name", "eagle");
        //3.获取数据
        String value = jedis.get("name");
        System.out.println(value);
        //4.释放资源
        jedis.close();
    }

    /**
     * 连接池方式
     */
    @Test
    public void demo2() {
        //获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.56.104", 6379);

        //获得核心对象jedis
        Jedis jedis = null;
        try {
            //通过连接池获得连接
            jedis = jedisPool.getResource();
            jedis.auth("123456");
            //设置数据
            jedis.set("age", "18");
            jedis.set("address", "山东省");
            jedis.set("name", "mine");
            String address = jedis.get("address");
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
                ;
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }
    }
}
