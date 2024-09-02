package com.infect.mapper;

import com.infect.entity.Labtestreport;
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
public interface LabtestreportMapper extends BaseMapper<Labtestreport> {

    @Select("select LabTestReportID from labtestreport where UserID = #{userId} and UploadDate = #{now}")
    Integer selectLabTestReportIdByUserIdAndDate(Integer userId, LocalDate now);
}
