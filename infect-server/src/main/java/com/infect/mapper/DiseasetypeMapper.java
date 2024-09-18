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

    @Select("select DiseaseTypeName from diseasetype")
    List<String> selectDiseaseTypeNameList();
}
