package com.gt.inside;

import com.gt.inside.api.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by psr on 2017/11/21 0021.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testRedis(){
        redisUtil.setKey("key1", "hello redis");
        redisUtil.setKey("key2", "good redis");
        System.out.println(redisUtil.getValue("key1"));
        System.out.println(redisUtil.getValue("key2"));
    }

}
