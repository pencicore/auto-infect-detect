package com.infect.mapper;

import com.infect.entity.Dailyhealthstatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.infect.temporary.DiseaseNameNumberPairTemp;
import com.infect.temporary.StationTemp;
import com.infect.vo.system.CheckinDailyNumberVO;
import com.infect.vo.system.CheckinInfoStatisticsVO;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface DailyhealthstatusMapper extends BaseMapper<Dailyhealthstatus> {

    /**
     * 根据时间获取各个疾病当天患病人数
     *
     * @param now
     * @return
     */
    List<DiseaseNameNumberPairTemp> selectDiseaseNumber(LocalDate now);

    /**
     * 根据时间获取用户位置的经纬度
     * @param now
     * @return
     */
    @Select("select Longitude,Latitude from dailyhealthstatus where CheckInDate = #{now}")
    List<StationTemp> selectStationListByTime(LocalDate now);

    /**
     * 根据text对多个字段进行模糊查询infoNumber条数据
     * @param ids
     * @param infoNumber
     * @return
     */
    List<CheckinInfoStatisticsVO> selectChickInInfo(List<Integer> ids, Integer infoNumber);

    /**
     * 查询一段时间内每天签到人数
     * @param startDate
     * @param endDate
     * @return
     */
    List<CheckinDailyNumberVO> selectChickInDailyNumber(LocalDate startDate, LocalDate endDate);

    /**
     * 查询一段时间内有患病情况的用户id
     *
     * @param startDate
     * @param endDate
     * @return
     */
    List<Integer> selectUerIdByIsHealth(LocalDate startDate, LocalDate endDate);
}
