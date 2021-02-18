package com.timberliu.springboot.validation.controller;

import com.timberliu.springboot.validation.dto.UserAddDTO;
import com.timberliu.springboot.validation.dto.UserUpdateGenderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Validated 添加到类上，表示该类所有接口都需要进行参数校验
 *
 * @author: Timber
 * @date: 2021/2/7
 */
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/get")
    public void get(@RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {
        logger.info("[get][id: {}]", id);
    }

    @PostMapping("/add")
    public void add(@Valid UserAddDTO userAddDTO) {
        logger.info("[add][addDTO: {}]", userAddDTO);
    }

    @PostMapping("update_gender")
    public void updateGender(@Valid UserUpdateGenderDTO updateGenderDTO) {
        logger.info("[updateGender][updateGenderDTO: {}]", updateGenderDTO);
    }

}
