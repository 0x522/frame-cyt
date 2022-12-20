package com.cyt.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyt.user.entity.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPo> {
}
