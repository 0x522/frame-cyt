package com.cyt.user.controller;

import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.req.UserReq;
import com.cyt.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Integer addUser(@RequestBody UserReq userReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        return userService.addUser(userDto);
    }

}
