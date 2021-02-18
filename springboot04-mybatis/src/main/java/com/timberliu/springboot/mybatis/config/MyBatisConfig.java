package com.timberliu.springboot.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by Timber in 2020/7/20
 */
@Configuration
@MapperScan(basePackages = "com.timberliu.springboot.mapper")
public class MyBatisConfig {

}
