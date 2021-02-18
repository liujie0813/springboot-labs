package com.timberliu.springboot.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by Timber in 2020/7/21
 */
@Configuration
@MapperScan(basePackages = "com.timberliu.springboot.mybatisplus.mapper")
public class MyBatisPlusConfig {

}
