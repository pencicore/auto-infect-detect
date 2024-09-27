package com.infect.mapper;

import com.infect.entity.Diseasetype;
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
public interface DiseasetypeMapper extends BaseMapper<Diseasetype> {

    /**
     *获取疾病名列表
     * @return
     */
    @Select("select DiseaseTypeName from diseasetype")
    List<String> selectDiseaseTypeNameList();

    /**
     *根据疾病名获取疾病类型id
     * @param diseaseName
     * @return
     */
    @Select("select DiseaseTypeID from diseasetype where DiseaseTypeName = #{diseaseName}")
    Integer selectIdByName(String diseaseName);
}
