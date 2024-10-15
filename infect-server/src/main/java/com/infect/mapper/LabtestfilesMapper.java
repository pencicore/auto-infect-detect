package com.infect.mapper;

import com.infect.entity.Labtestfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     *将id为labTestReportId且id不在fileIds中的数据的labTestReportId设置为goalNum
     * @param goalNum
     * @param labTestReportId
     * @param fileIds
     */
    void updateLabTestReportIdByFileIds(Integer goalNum, Integer labTestReportId, List<Integer> fileIds);
}
