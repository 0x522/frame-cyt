package com.cyt.user.controller;

import com.cyt.redis.util.RedisShareLockUtil;
import com.cyt.redis.util.RedisUtil;
import com.cyt.tool.Base64Utils;
import com.cyt.tool.PinYin4jUtils;
import com.cyt.user.entity.po.UserPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/testPinyin")
    public void testPinyin(@RequestParam String input) {
        String pinYin = PinYin4jUtils.getPinYin(input);
        log.info("input convert to {}", pinYin);
    }

    @GetMapping("/testBase64")
    public void testBase64(@RequestParam String input) {
        try {
            String encode = Base64Utils.encode(input);
            log.info("加密后的input:{}", encode);
            String decode = Base64Utils.decode(encode);
            log.info("是否和输入相等{}", input.equals(decode));
        } catch (Exception e) {
            log.error("异常");
        }
    }

    @PostMapping("/testQuery")
    public void testQuery(@RequestBody UserPo user){
        System.out.println(user);
    }

}
