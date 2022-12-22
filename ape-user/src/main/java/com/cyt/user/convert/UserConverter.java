package com.cyt.user.convert;

import com.cyt.user.entity.dto.UserDto;
import com.cyt.user.entity.po.UserPo;
import com.cyt.user.entity.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(source = "age", target = "age")
    @Mapping(source = "name", target = "name")
    UserDto convertUserReqToUserDto(UserReq userReq);

    @Mapping(source = "age", target = "age")
    @Mapping(source = "name", target = "name")
    UserPo convertUserDtoToUserPo(UserDto userDto);
}
