package com.baidu.redis;

import com.baidu.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    public RedisService redisService;

    @Test
    public void contextLoads() {
        redisService.add("kkk", "asdasdas");
        Object kkk = redisService.get("kkk");
        System.out.println(kkk);
    }

}
