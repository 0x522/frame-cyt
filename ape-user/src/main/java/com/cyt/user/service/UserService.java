package com.cyt.user.service;

import com.cyt.user.entity.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int addUser(UserDto userDto);
}
