package com.cyt.user.cache;

import com.cyt.redis.init.AbstractCache;
import com.cyt.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherCache extends AbstractCache {

    public static String OTHER_CACHE = "OTHER";

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void initCache() {
        //TODO 数据来源
        redisUtil.set("other", "hahah");
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
        redisUtil.del(OTHER_CACHE);
    }

}
