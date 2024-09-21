package com.infect.mapper;

import com.infect.entity.Diagnosisexaminations;
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
public interface DiagnosisexaminationsMapper extends BaseMapper<Diagnosisexaminations> {
    @Select("select * from diagnosisexaminations where DiagnosisResultsID = #{userId}")
    Diagnosisexaminations selectByDiagnosisResultsId(Integer userId);
}
