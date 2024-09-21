package com.infect.mapper;

import com.infect.entity.Diagnosisdigestivesymptoms;
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
public interface DiagnosisdigestivesymptomsMapper extends BaseMapper<Diagnosisdigestivesymptoms> {
    @Select("select * from diagnosisdigestivesymptoms where DiagnosisResultsID = #{userId}")
    Diagnosisdigestivesymptoms selectByDiagnosisResultsId(Integer userId);
}
