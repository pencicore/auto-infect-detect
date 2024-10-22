package com.infect.mapper;

import com.infect.entity.Symptomweighting;
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
public interface SymptomweightingMapper extends BaseMapper<Symptomweighting> {

    @Select("select * from symptomweighting where TableName=#{tableName}")
    List<Symptomweighting> selectByTableName(String generalSymptoms);

    @Select("select * from symptomweighting")
    List<Symptomweighting> selectAll();
}
