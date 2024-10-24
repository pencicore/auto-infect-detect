package com.infect.mapper;

import com.infect.entity.Diagnosisneurologicalsymptoms;
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
public interface DiagnosisneurologicalsymptomsMapper extends BaseMapper<Diagnosisneurologicalsymptoms> {
    @Select("select * from diagnosisneurologicalsymptoms where DiagnosisResultsID = #{userId}")
    Diagnosisneurologicalsymptoms selectByDiagnosisResultsId(Integer userId);
}
