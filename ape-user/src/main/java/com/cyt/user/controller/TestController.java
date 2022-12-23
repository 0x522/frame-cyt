package com.cyt.user.controller;

import com.cyt.redis.util.RedisShareLockUtil;
import com.cyt.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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

    @GetMapping("/testLog")
    public void testLog() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            log.info("这是第{}条日志", i);
        }
        log.info("输出所用时间{}", System.currentTimeMillis() - startTime);
    }
}
