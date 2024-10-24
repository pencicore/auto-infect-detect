package com.infect.mapper;

import com.infect.entity.Diagnosisrespiratorysymptoms;
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
public interface DiagnosisrespiratorysymptomsMapper extends BaseMapper<Diagnosisrespiratorysymptoms> {
    @Select("select * from diagnosisrespiratorysymptoms where DiagnosisResultsID = #{userId}")
    Diagnosisrespiratorysymptoms selectByDiagnosisResultsId(Integer userId);
}
