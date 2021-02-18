package com.timberliu.springboot.redis;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * created by Timber in 2020/7/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot06RedisApplication.class)
public class RedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringSetKey() {
        stringRedisTemplate.opsForValue().set("liu", "jie");
    }

    @Test
    public void test1() throws IOException {
        String scriptContents = IOUtils.toString(
                getClass().getResourceAsStream("/lua/compareAndSet.lua"), StandardCharsets.UTF_8);
        RedisScript<Long> script = new DefaultRedisScript<>(scriptContents, Long.class);
        Long res = stringRedisTemplate.execute(script, Collections.singletonList("liu"), "jie", "haha");
        System.out.println(res);
    }

}
