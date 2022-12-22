package com.cyt.user.service;

import com.cyt.entity.PageResult;
import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.po.UserPo;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    int addUser(UserDto userDto);

    Integer deleteUser(Long id);

    PageResult<UserPo> getUserPage(UserDto userDto);

    Integer updateUser(UserPo user);
}
