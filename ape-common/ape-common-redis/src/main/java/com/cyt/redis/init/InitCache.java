package com.cyt.redis.init;

import com.cyt.redis.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class InitCache implements CommandLineRunner {
    // 项目启动后执行
    @Override
    public void run(String... args) throws Exception {
        log.info("开启缓存预热");

        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        //拿到抽象类下面的继承类
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        //init
        if (beanMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, AbstractCache> entry : beanMap.entrySet()) {
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }
}
