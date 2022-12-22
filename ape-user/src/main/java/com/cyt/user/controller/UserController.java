package com.cyt.user.controller;

import com.cyt.bean.Result;
import com.cyt.user.convert.UserConverter;
import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.po.UserPo;
import com.cyt.user.entity.req.UserListReq;
import com.cyt.user.entity.req.UserReq;
import com.cyt.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户Controller")
public class UserController {
    //Restful

    @Autowired
    private UserService userService;

    @PostMapping
    public Result addUser(@RequestBody UserReq userReq) {
        UserDto userDto = UserConverter.INSTANCE.convertUserReqToUserDto(userReq);
        return Result.ok(userService.addUser(userDto));
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return Result.ok(userService.deleteUser(id));
    }

    @PutMapping
    public Result updateUser(@RequestBody UserPo user) {
        return Result.ok(userService.updateUser(user));
    }

    @GetMapping
    public Result getPageData(@RequestBody UserListReq userListReq) {
        UserDto userDto = new UserDto();
        System.out.println(userListReq.toString());
        BeanUtils.copyProperties(userListReq, userDto);
        return Result.ok(userService.getUserPage(userDto));
    }


}
