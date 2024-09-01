package com.infect.mapper;

import com.infect.entity.Diagnosisresults;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface DiagnosisresultsMapper extends BaseMapper<Diagnosisresults> {

    @Select("select DiagnosisResultsID from diagnosisresults where UserID = #{userId} and SubmissionTime = #{nowTime}")
    Integer selectIdByUserIdAndTime(Integer userId, LocalDate nowTime);
}
