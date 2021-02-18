package com.timberliu.springboot.springmvc.message.converter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * created by Timber in 2020/7/6
 */
@Configuration
public class SpringMVC4Configuration implements WebMvcConfigurer {

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE));
//
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
//        converters.add(converter);
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new ParameterNamesModule(), new Jdk8Module(), new JavaTimeModule());
        // 注册所有模块
//        objectMapper.findAndRegisterModules();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(converter);
    }

    //    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 自定义 FastJson 配置
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setCharset(Charset.defaultCharset());
//        // 剔除循环引用
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
//        // 创建 FastJsonHttpMessageConverter 对象
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        // 设置支持的 MediaType
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        // 添加到 converters
//        converters.add(0, fastJsonHttpMessageConverter);
//    }

}
