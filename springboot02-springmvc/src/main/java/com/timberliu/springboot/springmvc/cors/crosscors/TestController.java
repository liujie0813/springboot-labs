package com.timberliu.springboot.springmvc.cors.crosscors;

import com.timberliu.springboot.springmvc.globalexception.domain.UserVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Timber in 2020/7/2
 */
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class TestController {

    @GetMapping("/get")
    @CrossOrigin(allowCredentials = "false")
    public UserVO get() {
        return new UserVO().setId(1).setUsername("liu");
    }

}
