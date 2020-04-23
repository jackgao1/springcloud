package com.baidu.redis;

import com.baidu.redis.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RedisApplicationTests {
    @Autowired
    public RedisService redisService;

    @Test
    void contextLoads() {
        redisService.add("kkk", "asdasdas");
        Object kkk = redisService.get("kkk");
        System.out.println(kkk);
    }

}
