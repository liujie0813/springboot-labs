package com.timberliu.springboot.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timberliu.springboot.mybatisplus.dataobject.UserDO;
import com.timberliu.springboot.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * created by Timber in 2020/7/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot05MybatisPlusApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO userDO = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("liu").setCreateTime(new Date())
                .setDeleted(0);
        userMapper.insert(userDO);
    }

    @Test
    public void testSelectByUsername() {
        UserDO liu = userMapper.selectByUsername("liu");
        System.out.println(liu);
    }

    @Test
    public void testSelectByIds() {
        List<UserDO> userDOS = userMapper.selectByIds(Arrays.asList(7, 8));
        System.out.println(userDOS.size());
    }

    @Test
    public void SelectPageByCreateTime() {
        IPage<UserDO> page = new Page<>(1, 10);
        Date date = new Date(2020 - 1990, Calendar.JULY, 21);
        page = userMapper.selectPageByCreateTime(page, date);
        System.out.println(page.getRecords().size());
    }

}
