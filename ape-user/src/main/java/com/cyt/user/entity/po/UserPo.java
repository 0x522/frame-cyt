package com.cyt.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.cyt.entity.BaseEntity;
import lombok.Data;


@TableName("user")
@Data
public class UserPo extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer age;

}
