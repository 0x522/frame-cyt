package com.cyt.user.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private String name;

    private Integer age;
}
