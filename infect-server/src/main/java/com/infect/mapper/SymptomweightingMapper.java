package com.infect.mapper;

import com.infect.dto.system.UpdateBatchWeightScoringDTO;
import com.infect.entity.Symptomweighting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import java.math.BigDecimal;
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

<<<<<<< HEAD
    @Select("select * from symptomweighting where TableName=#{tableName}")
    List<Symptomweighting> selectByTableName(String generalSymptoms);

    @Select("select * from symptomweighting")
    List<Symptomweighting> selectAll();
=======
    BigDecimal selectCountByUpdateDTOList(List<UpdateBatchWeightScoringDTO> updateDTOList);
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
}
