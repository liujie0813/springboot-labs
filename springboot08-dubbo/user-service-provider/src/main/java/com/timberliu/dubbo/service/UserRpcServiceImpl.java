package com.timberliu.dubbo.service;

import com.timberliu.dubbo.api.UserRpcService;
import com.timberliu.dubbo.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

/**
 * created by Timber in 2020/8/2
 */
@Service(version = "${dubbo.provider.UserRpcService.version}")
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("昵称");
        userDTO.setGender(1);
        return userDTO;
    }
}
