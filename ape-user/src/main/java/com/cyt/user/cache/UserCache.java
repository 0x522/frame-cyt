package com.cyt.user.cache;

import com.cyt.redis.init.AbstractCache;
import com.cyt.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCache extends AbstractCache {

    public static String USER_CACHE_KEY = "USER";

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void initCache() {
        //TODO 数据来源
        redisUtil.set("age", "20");
    }

    @Override
    public <T> T getCache(String key) {
        if (!redisUtil.isExistsKey(key)) {
            reloadCache();
        }
        return (T) redisUtil.get(key);
    }

    @Override
    public void clearCache() {
        redisUtil.del(USER_CACHE_KEY);
    }
}
