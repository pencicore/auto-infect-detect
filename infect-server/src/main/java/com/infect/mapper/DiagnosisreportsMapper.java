package com.infect.mapper;

import com.infect.entity.Diagnosisreports;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.awt.*;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface DiagnosisreportsMapper extends BaseMapper<Diagnosisreports> {

    @Select("update diagnosisreports set DiagnosisResultsID = #{diagnosisResultId} where ReportID = #{fileId}")
    void updateDiagnosisResultIdByFileId(Integer fileId, Integer diagnosisResultId);

    @Select("select DiagnosisResultsID from diagnosisreports where FilePath=#{s}")
    Integer selectIdByFilePath(String s);

    @Select("select ReportID from diagnosisreports where DiagnosisResultsID=#{userId}")
    List selectFileIdsByDiagnosisResultId(Integer userId);

    /**
     * 根据诊断结果id查询诊断报告文件id列表
     * 
     * @param diagnosisResultsID
     * @return
     */
    @Select("select ReportID from diagnosisreports where DiagnosisResultsID = #{diagnosisResultsID}")
    List<Integer> selectIdsByDiagnosisResultsID(Integer diagnosisResultsID);
}
