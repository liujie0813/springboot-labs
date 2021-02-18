package com.timberliu.springboot;

import com.timberliu.springboot.mybatis.Springboot04MybatisApplication;
import com.timberliu.springboot.mybatis.dataobject.UserDO;
import com.timberliu.springboot.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * created by Timber in 2020/7/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot04MybatisApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO userDO = new UserDO().setUsername("liu")
                .setPassword("password").setCreateTime(new Date());
        userMapper.insert(userDO);
    }

    @Test
    public void testUpdateById() {
        UserDO userDO = new UserDO().setId(4).setPassword("password1");
        userMapper.updateById(userDO);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(4);
    }

    @Test
    public void testSelectById() {
        UserDO userDO = userMapper.selectById(5);
        System.out.println(userDO);
    }

    @Test
    public void testSelectByUsername() {
        UserDO userDO = userMapper.selectByUsername("liu");
        System.out.println(userDO);
    }

    @Test
    public void testSelectByIds() {
        List<UserDO> userDOS = userMapper.selectByIds(Arrays.asList(4, 5));
        System.out.println(userDOS.size());
    }

}
