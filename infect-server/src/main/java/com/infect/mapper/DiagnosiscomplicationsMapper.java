package com.infect.mapper;

import com.infect.entity.Diagnosiscomplications;
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
public interface DiagnosiscomplicationsMapper extends BaseMapper<Diagnosiscomplications> {
    @Select("select * from diagnosiscomplications where DiagnosisResultsID = #{userId}")
    Diagnosiscomplications selectByDiagnosisResultsId(Integer userId);
}
