package com.timberliu.dubbo;

import com.timberliu.dubbo.api.UserRpcService;
import com.timberliu.dubbo.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceConsumerApplicationTests {

    //    @Resource
    @Reference(version = "${dubbo.consumer.UserRpcService.version}")
    private UserRpcService userRpcService;

    @Test
    void contextLoads() {
        UserDTO userDTO = userRpcService.get(1);
        System.out.println(userDTO);
    }

}
