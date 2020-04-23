package com.baidu.redis.controller;

import com.baidu.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("redis")
    public Object contextLoads() {
        redisService.set("key", "测试");
        return redisService.get("key");
    }
}