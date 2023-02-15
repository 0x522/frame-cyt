package com.cyt.user.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ApplicationInit implements ApplicationListener<ApplicationReadyEvent> {

    interface InitFunction {
        void invoke();
    }

    //服务预热
    Map<String, InitFunction> initFunctionMap = new HashMap<>();

    {
        initFunctionMap.put("fastjson", this::initFastjson);
        initFunctionMap.put("redis", this::initRedis);
        initFunctionMap.put("http", this::initHttpClient);
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("服务启动后调用");
        initFunctionMap.forEach((k, v) -> {
            try {
                //遍历预热逻辑
                //计算耗时
                long start = System.currentTimeMillis();
                v.invoke();
                log.info("{} execute costTime {}", k, System.currentTimeMillis() - start);
            } catch (Exception e) {
                log.error("error{}", k, e);
            }
        });


    }

    private void initFastjson() {
        //fastjson预热

    }

    private void initRedis() {
        //redis预热

    }

    private void initHttpClient() {
        //http预热

    }
}
