package com.infect.mapper;

import com.infect.entity.Diagnosislocalsymptoms;
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
public interface DiagnosislocalsymptomsMapper extends BaseMapper<Diagnosislocalsymptoms> {
    @Select("select * from diagnosislocalsymptoms where DiagnosisResultsID = #{userId}")
    Diagnosislocalsymptoms selectByDiagnosisResultsId(Integer userId);
}
