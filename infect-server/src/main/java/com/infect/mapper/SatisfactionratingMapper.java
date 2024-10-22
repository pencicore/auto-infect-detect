package com.infect.mapper;

import cn.hutool.core.lang.Pair;
import com.infect.entity.Satisfactionrating;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.infect.temporary.SatisfactionPairTemp;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
public interface SatisfactionratingMapper extends BaseMapper<Satisfactionrating> {

    @Select("select SatisfactionLevel,count(*) as count from satisfactionrating where SurveyID = #{surveyID} GROUP BY SatisfactionLevel")
    List<SatisfactionPairTemp> selectSatisfactionNumberAndTotalNumber(Integer surveyID);
}
