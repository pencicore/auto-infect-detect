package com.infect.mapper;

import com.infect.entity.Systemsettings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-25
 */
public interface SystemsettingsMapper extends BaseMapper<Systemsettings> {

    @Select("update systemsettings set IsAI = #{isAI} where 1 = 1 ")
    void systemChangExpertOrAI(Boolean isAI);
}
