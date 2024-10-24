package com.infect.mapper;

import com.infect.entity.Diagnosisresults;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.infect.temporary.DiseaseStatisticsInfoTemp;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface DiagnosisresultsMapper extends BaseMapper<Diagnosisresults> {

    @Select("select DiagnosisResultsID from diagnosisresults where UserID = #{userId} and SubmissionTime = #{nowTime}")
    Integer selectIdByUserIdAndTime(Integer userId, LocalDate nowTime);

    @Select("select * from diagnosisresults where UserID = #{currentId} and SubmissionTime = #{date}")
    Diagnosisresults selectByUserIdAndTime(Integer currentId, Date date);

    List<DiseaseStatisticsInfoTemp> selectDiseaseStatisticsList(String sourceType, List<String> diseaseList,
            LocalDate dateBegin, LocalDate dateEnd);
}
