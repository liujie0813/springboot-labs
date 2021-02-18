package com.timberliu.springboot.springmvc.handlerinterceptor.controller;

import com.timberliu.springboot.springmvc.handlerinterceptor.annotation.AccessLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2020/5/26
 * @author: Timber
 */
@RestController
@RequestMapping("/user")
public class FangshuaController {

    @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public String fangshua() {
        return "请求成功";
    }

}
