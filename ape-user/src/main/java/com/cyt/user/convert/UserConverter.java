package com.cyt.user.convert;

import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.po.UserPo;
import com.cyt.user.entity.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserReqToUserDto(UserReq userReq);

    UserPo convertUserDtoToUserPo(UserDto userDto);
}
