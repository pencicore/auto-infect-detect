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
    private Integer EnvironmentID;

    private Integer UserID;

    private String YearMonth;

    private LocalDateTime SubmissionTime;

    private Integer WorkStationAltitude;

    private String WorkStationName;

    private Integer DormitoryBuildingNumber;

    private Integer DormitoryRoomNumber;

    private Integer DormitoryOccupants;

    private BigDecimal DormitoryArea;

    private BigDecimal WindowOpenArea;

    private String VentilationCondition;

    private Integer AvgWorkRoomPeople;

    private Integer AvgWorkFaceToFace;

    private Integer AvgWorkPhysicalContact;

    private Integer AvgBreakfastRoomPeople;

    private Integer AvgBreakfastFaceToFace;

    private Integer AvgBreakfastPhysicalContact;

    private Integer AvgLunchRoomPeople;

    private Integer AvgLunchFaceToFace;

    private Integer AvgLunchPhysicalContact;

    private Integer AvgDinnerRoomPeople;

    private Integer AvgDinnerFaceToFace;

    private Integer AvgDinnerPhysicalContact;

    private Integer CollectiveActivitiesCount;

    private Integer AvgActivityRoomPeople;

    private Integer AvgActivityFaceToFace;

    private Integer AvgActivityPhysicalContact;

    private BigDecimal AvgMonthlyPressure;

    private BigDecimal MaxTemperature;

    private BigDecimal MinTemperature;


}
