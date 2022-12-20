package com.cyt.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyt.entity.PageResult;
import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.po.UserPo;
import com.cyt.user.mapper.UserMapper;
import com.cyt.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        return userMapper.insert(userPo);
    }

    @Override
    public Integer deleteUser(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<UserPo> getUserPage(UserDto userDto) {
        IPage<UserPo> userPoPage = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPoPage);
        PageResult<UserPo> pageResult = new PageResult<>();
        pageResult.loadPageData(userPage);
        return pageResult;
    }


    @Override
    public Integer updateUser(UserPo user) {
        if (user != null) {
            UpdateWrapper<UserPo> uw = new UpdateWrapper<>();
            uw.set("name", user.getName())
                    .set("age", user.getAge())
                    .eq("id", user.getId());
            return userMapper.update(new UserPo(), uw);
        }
        return null;
    }

}
