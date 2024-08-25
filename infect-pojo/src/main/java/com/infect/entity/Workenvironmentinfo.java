package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("workenvironmentinfo")
@ApiModel(value="Workenvironmentinfo对象", description="")
public class Workenvironmentinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EnvironmentID", type = IdType.AUTO)
    private Integer environmentId;

    private Integer userId;

    private String yearMonth;

    private LocalDateTime submissionTime;

    private Integer workStationAltitude;

    private String workStationName;

    private Integer dormitoryBuildingNumber;

    private Integer dormitoryRoomNumber;

    private Integer dormitoryOccupants;

    private BigDecimal dormitoryArea;

    private BigDecimal windowOpenArea;

    private String ventilationCondition;

    private Integer avgWorkRoomPeople;

    private Integer avgWorkFaceToFace;

    private Integer avgWorkPhysicalContact;

    private Integer avgBreakfastRoomPeople;

    private Integer avgBreakfastFaceToFace;

    private Integer avgBreakfastPhysicalContact;

    private Integer avgLunchRoomPeople;

    private Integer avgLunchFaceToFace;

    private Integer avgLunchPhysicalContact;

    private Integer avgDinnerRoomPeople;

    private Integer avgDinnerFaceToFace;

    private Integer avgDinnerPhysicalContact;

    private Integer collectiveActivitiesCount;

    private Integer avgActivityRoomPeople;

    private Integer avgActivityFaceToFace;

    private Integer avgActivityPhysicalContact;

    private BigDecimal avgMonthlyPressure;

    private BigDecimal maxTemperature;

    private BigDecimal minTemperature;

}
