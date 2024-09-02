package com.infect.mapper;

import com.infect.entity.Labtestfiles;
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
public interface LabtestfilesMapper extends BaseMapper<Labtestfiles> {

    @Select("select FileID from labtestfiles where FilePath=#{s}")
    Integer selectIdByFilePath(String s);

    @Select("update labtestfiles set LabTestReportID = #{labTestReportId} where FileID = #{fileId}")
    void updateLabTestReportIdByFileId(Integer fileId, Integer labTestReportId);
}
