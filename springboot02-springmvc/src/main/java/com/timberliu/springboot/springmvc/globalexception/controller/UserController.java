package com.timberliu.springboot.springmvc.globalexception.controller;

import com.timberliu.springboot.springmvc.globalexception.common.CommonResult;
import com.timberliu.springboot.springmvc.globalexception.common.ServiceExceptionEnum;
import com.timberliu.springboot.springmvc.globalexception.domain.UserVO;
import com.timberliu.springboot.springmvc.globalexception.common.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @date: 2020/5/26
 * @author: Timber
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
        // 返回结果
        return CommonResult.success(user);
    }

    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("空指针异常");
    }

    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

}
