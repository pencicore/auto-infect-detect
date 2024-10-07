package com.infect.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.infect.vo.system.ImportantUserInfoVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    //根据用户id获取账户状态
    @Select("select IsActived from user where UserID = #{userId}")
    Boolean selectIsActivedByUserId(Integer userId);

    //根据id修改账号状态
    @Select("update user set IsActived = #{status} where UserID = #{userId}")
    void updateIsActivedByUserId(Integer userId, Boolean status);

    //更具用户id获取身份证号
    @Select("select IDNumber from user where UserID = #{userId}")
    String selectIdNumberByUserId(Integer userId);

    //根据id修改用户密码
    @Select("update user set Password = #{password} where UserID = #{userId}")
    void updateIdNumberByUserId(String password, Integer userId);

    /**
     * 根据wrapper条件查询用户id
     * @param wrapper
     * @return
     */
    @Select("select UserID from user ${ew.customSqlSegment}")
    List<Integer> selectIdsByWrapper(@Param("ew") LambdaQueryWrapper<User> wrapper);

    /**
     * 查询HasMedicalHistory为true的用户信息
     * @return
     */
    @Select("select userId, name, department from user where HasMedicalHistory = true")
    List<ImportantUserInfoVO> selectHasMedicalHistoryIsTrue();

    /**
     * 根据身份证和电话查询是否有重复用户
     * @param phoneNumber
     * @param idNumber
     * @return
     */
    @Select("select count(*) from user where IDNumber = #{idNumber} or PhoneNumber = #{phoneNumber}")
    Integer selectCountByIdNumberOrPhoneNumber(String phoneNumber, String idNumber);
}
