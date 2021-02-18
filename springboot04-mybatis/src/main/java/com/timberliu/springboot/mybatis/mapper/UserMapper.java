package com.timberliu.springboot.mybatis.mapper;

import com.timberliu.springboot.mybatis.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * created by Timber in 2020/7/20
 */
// 标记是数据访问 Bean 对象
@Repository
public interface UserMapper {

    int insert(UserDO userDO);

    // 一般，在 SQL 的 where 条件的字段，建议带在方法名后，如果是多个字段，可以使用 and 分割
    int updateById(UserDO userDO);

    /**
     * 生产请使用逻辑删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    // 单参数时，非必须
    // 多参数时，必须。
    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

}
