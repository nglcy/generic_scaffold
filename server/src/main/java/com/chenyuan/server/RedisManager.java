/*
package com.chenyuan.server;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.JedisClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

*/
/**
 * @ClassName RedisManager
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/11/27 22:49
 *//*

@Component
@Slf4j
public class RedisManager {
    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value) {
        Jedis cline = jedisPool.getResource();
        String set = cline.set(key, value);
        log.info("heeeeeeeeeee",set);

    }

    public String get(String key) {
        String s = jedisPool.getResource().get(key);
        return s;
    }

}
*/
