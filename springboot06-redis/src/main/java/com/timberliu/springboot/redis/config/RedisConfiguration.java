package com.timberliu.springboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * created by Timber in 2020/7/21
 */
@Configuration
public class RedisConfiguration {

    //@Bean
    public RedisTemplate<String, Object> stringRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(factory);
        // StringRedisSerializer.UTF_8
        template.setKeySerializer(RedisSerializer.string());
        // GenericJackson2JsonRedisSerializer
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }

}
