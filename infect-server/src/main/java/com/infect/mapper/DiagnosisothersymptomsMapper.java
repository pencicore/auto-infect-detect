package com.infect.mapper;

import com.infect.entity.Diagnosisothersymptoms;
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
public interface DiagnosisothersymptomsMapper extends BaseMapper<Diagnosisothersymptoms> {
    @Select("select * from diagnosisothersymptoms where DiagnosisResultsID = #{userId}")
    Diagnosisothersymptoms selectByDiagnosisResultsId(Integer userId);
}
