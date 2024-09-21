package com.infect.mapper;

import com.infect.entity.Labtestreport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

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
    List<Integer> selectLabTestReportIdByUserIdAndDate(Integer userId, LocalDate now);

    @Select("select * from labtestreport where UploadDate = #{date} and UserID = #{currentId}")
    List<Labtestreport> getReportFile(String date, Integer currentId);
}
