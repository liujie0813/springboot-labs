package com.timberliu.springboot.mapstruct.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * created by Timber in 2020/7/25
 */
@Data
@Accessors(chain = true)
public class ConsumerDO {

    private Integer id;

    private String username;

    private String password;
}
