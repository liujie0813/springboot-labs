package com.timberliu.springboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * created by Timber in 2020/7/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot06RedisApplication.class)
public class RateLimiterTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test1() throws Exception {
        RRateLimiter myRateLimiter = redissonClient.getRateLimiter("myRateLimiter");
        myRateLimiter.trySetRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 5; i++) {
            System.out.println(simpleDateFormat.format(new Date()) + ": 获得锁结果(" + myRateLimiter.tryAcquire() + ")");
            Thread.sleep(250L);
        }
    }

}
