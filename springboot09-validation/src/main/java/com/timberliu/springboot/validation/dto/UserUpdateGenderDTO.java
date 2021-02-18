package com.timberliu.springboot.validation.dto;

import com.timberliu.springboot.validation.constants.GenderEnum;
import com.timberliu.springboot.validation.core.validator.InEnum;

import javax.validation.constraints.NotNull;

/**
 * @author: Timber
 * @date: 2021/2/7
 */
public class UserUpdateGenderDTO {

    @NotNull(message = "用户编号不能为空")
    private Integer id;

    @NotNull(message = "性能不能为空")
    @InEnum(value = GenderEnum.class, message = "性别必须是 {value}")
    private Integer gender;
}
