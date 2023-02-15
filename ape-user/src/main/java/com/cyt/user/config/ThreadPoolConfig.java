package com.cyt.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {
    @Bean(name = "mailThreadPool")
    public ThreadPoolExecutor getMailThreadPool() {
        //自定义线程工厂
        CustomNameThreadFactory mail = new CustomNameThreadFactory("mail");

        return new ThreadPoolExecutor(20, 50, 5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), mail, new ThreadPoolExecutor.DiscardPolicy());
    }


}
