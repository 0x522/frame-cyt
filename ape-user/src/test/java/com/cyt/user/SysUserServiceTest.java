package com.cyt.user;

import com.cyt.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SysUserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testQuery() {

    }

    @Test
    public void testAopUtil() {
        Class<?> targetClass = AopUtils.getTargetClass(userService);
        System.out.println(targetClass.getSimpleName());
    }

}
