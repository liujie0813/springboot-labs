package com.timberliu.springboot.springmvc.handlerinterceptor.controller;

import com.timberliu.springboot.springmvc.globalexception.common.ServiceExceptionEnum;
import com.timberliu.springboot.springmvc.globalexception.domain.UserVO;
import com.timberliu.springboot.springmvc.globalexception.common.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @date: 2020/5/26
 * @author: Timber
 */
@RestController
@RequestMapping("/user")
public class UserController1 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/do_something")
    public void doSomething() {
        logger.info("[doSomething]");
    }

    @GetMapping("/current_user")
    public UserVO currentUser() {
        logger.info("[currentUser]");
        return new UserVO().setId(10).setUsername(UUID.randomUUID().toString());
    }

    @GetMapping("/exception-03")
    public void exception03() {
        logger.info("[exception03]");
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

}
