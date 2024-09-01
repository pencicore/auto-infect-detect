package com.infect.mapper;

import com.infect.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface UserMapper extends BaseMapper<User> {

    //根据用户id获取用户名
    @Select("select user.Name from user where UserId = #{userId}")
    String selectNameById(Integer userId);
}
