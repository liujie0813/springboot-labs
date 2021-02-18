package com.timberliu.springboot.mapstruct.convert;

import com.timberliu.springboot.mapstruct.bo.ConsumerBO;
import com.timberliu.springboot.mapstruct.bo.UserBO;
import com.timberliu.springboot.mapstruct.dataobject.ConsumerDO;
import com.timberliu.springboot.mapstruct.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * created by Timber in 2020/7/25
 */
@Mapper
public interface ConsumerConvert {

    ConsumerConvert INSTANCE = Mappers.getMapper(ConsumerConvert.class);

    ConsumerBO convert(ConsumerDO consumerDO);

}
