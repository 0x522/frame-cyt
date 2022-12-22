package com.cyt.user.controller;

import com.cyt.redis.util.RedisShareLockUtil;
import com.cyt.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @GetMapping("/testRedis")
    public void testRedis() {
        redisUtil.set("name", "chenyuntao");
    }

    @GetMapping("/testRedisShareLock")
    public void testRedisShareLock() {
        boolean result = redisShareLockUtil.lock("cyt", "123456", 100000L);
        System.out.println(result);
    }
}
