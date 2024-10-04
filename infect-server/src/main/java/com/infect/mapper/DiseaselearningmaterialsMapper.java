package com.infect.mapper;

import com.infect.entity.Diseaselearningmaterials;
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
public interface DiseaselearningmaterialsMapper extends BaseMapper<Diseaselearningmaterials> {

    @Select("select min(SequenceNumber) from diseaselearningmaterials where SequenceNumber > #{sequenceNumber}")
    Integer selectSequenceNumberNextUp(Integer sequenceNumber);

    @Select("select max(SequenceNumber) from diseaselearningmaterials where SequenceNumber < #{sequenceNumber}")
    Integer selectSequenceNumberNextDown(Integer sequenceNumber);

    @Select("update diseaselearningmaterials set SequenceNumber = #{b} where SequenceNumber = #{a};")
    void updateSequenceNumberAndSequenceNumber(Integer a, Integer b);
}
