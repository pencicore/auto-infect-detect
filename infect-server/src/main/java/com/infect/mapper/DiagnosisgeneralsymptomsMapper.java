package com.infect.mapper;

import com.infect.entity.Diagnosisgeneralsymptoms;
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
public interface DiagnosisgeneralsymptomsMapper extends BaseMapper<Diagnosisgeneralsymptoms> {

    @Select("select * from diagnosisgeneralsymptoms where DiagnosisResultsID = #{userId}")
    Diagnosisgeneralsymptoms selectByDiagnosisResultsId(Integer userId);
}
