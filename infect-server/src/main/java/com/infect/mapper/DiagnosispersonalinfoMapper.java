package com.infect.mapper;

import com.infect.entity.Diagnosispersonalinfo;
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
public interface DiagnosispersonalinfoMapper extends BaseMapper<Diagnosispersonalinfo> {

    @Select("select * from diagnosispersonalinfo where DiagnosisResultsID = #{userId}")
    Diagnosispersonalinfo selectByDiagnosisResultsId(Integer userId);
}
