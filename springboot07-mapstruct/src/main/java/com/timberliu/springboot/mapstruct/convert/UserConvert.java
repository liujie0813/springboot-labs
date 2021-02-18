package com.timberliu.springboot.mapstruct.convert;

import com.timberliu.springboot.mapstruct.bo.UserBO;
import com.timberliu.springboot.mapstruct.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * created by Timber in 2020/7/25
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserBO convert(UserDO userDO);

}
