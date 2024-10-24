package com.infect.mapper;

import com.infect.entity.Diagnosiscirculatorysymptoms;
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
public interface DiagnosiscirculatorysymptomsMapper extends BaseMapper<Diagnosiscirculatorysymptoms> {
    @Select("select * from diagnosiscirculatorysymptoms where DiagnosisResultsID = #{userId}")
    Diagnosiscirculatorysymptoms selectByDiagnosisResultsId(Integer userId);
}
