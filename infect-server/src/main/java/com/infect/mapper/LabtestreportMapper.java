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

    /**
     * 根据实验报告id查询实验文件id列表
     *
     * @return
     */
    @Select("select FileID from labtestfiles where LabTestReportID = #{labTestReportID}")
    List<Integer> selectIdsByLabTestReportID(Integer labTestReportID);
}
