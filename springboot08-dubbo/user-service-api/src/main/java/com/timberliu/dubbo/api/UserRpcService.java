package com.timberliu.dubbo.api;

import com.timberliu.dubbo.dto.UserDTO;

/**
 * created by Timber in 2020/7/25
 */
public interface UserRpcService {

    UserDTO get(Integer id);
}
