package com.timberliu.springboot.springmvc.handlerinterceptor.config;

import com.timberliu.springboot.springmvc.handlerinterceptor.interceptors.FangshuaInteceptor;
import com.timberliu.springboot.springmvc.handlerinterceptor.interceptors.FirstInterceptor;
import com.timberliu.springboot.springmvc.handlerinterceptor.interceptors.SecondInterceptor;
import com.timberliu.springboot.springmvc.handlerinterceptor.interceptors.ThirdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @date: 2020/5/26
 * @author: Timber
 */
@Configuration
public class SpringMVC1Configuration implements WebMvcConfigurer {

    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    @Bean
    public FangshuaInteceptor fangshuaInteceptor() {
        return new FangshuaInteceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        // 拦截器一
//        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
//        // 拦截器二
//        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/user/current_user");
//        // 拦截器三
//        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");

        // 限流拦截器
        registry.addInterceptor(this.fangshuaInteceptor());
    }

}
