package com.infect.mapper;

import com.infect.entity.Workenvironmentinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface WorkenvironmentinfoMapper extends BaseMapper<Workenvironmentinfo> {

    @Update("UPDATE workenvironmentinfo SET " +
            "WorkStationAltitude = #{workStationAltitude}, " +
            "WorkStationName = #{workStationName}, " +
            "DormitoryBuildingNumber = #{dormitoryBuildingNumber}, " +
            "DormitoryRoomNumber = #{dormitoryRoomNumber}, " +
            "DormitoryOccupants = #{dormitoryOccupants}, " +
            "DormitoryArea = #{dormitoryArea}, " +
            "WindowOpenArea = #{windowOpenArea}, " +
            "VentilationCondition = #{ventilationCondition} " +
            "WHERE UserID = #{userId}")
    void updateWorkEnvironment(Workenvironmentinfo workenvironmentinfo);
}
