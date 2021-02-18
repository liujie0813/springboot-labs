package com.timberliu.springboot.redis;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * created by Timber in 2020/7/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot06RedisApplication.class)
public class LockTest {

    private static final String LOCK_KEY = "anylock";

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test1() throws Exception {
        new Thread(() -> {
            final RLock lock = redissonClient.getLock(LOCK_KEY);
            lock.lock(10, TimeUnit.SECONDS);
        }).start();
        Thread.sleep(1000L);

        System.out.println("准备开始获得锁时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        final RLock lock = redissonClient.getLock(LOCK_KEY);
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            System.out.println("实际获得锁时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } else {
            System.out.println("加锁失败");
        }
    }

}
