package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 个人工作环境表，每个月填写一次。
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("workenvironmentinfo")
@ApiModel(value = "Workenvironmentinfo对象", description = "个人工作环境表")
public class Workenvironmentinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "环境信息ID，自增", hidden = false, example = "1")
    @TableId(value = "EnvironmentID", type = IdType.AUTO)
    private Integer environmentId;

    @ApiModelProperty(value = "关联的用户ID", hidden = true)
    private Integer userId;

    @ApiModelProperty(value = "年月，格式为YYYY-MM", hidden = true)
    private String yearMonth;

    @ApiModelProperty(value = "提交时间，自动记录时间戳", required = true, example = "2024-08-24T12:34:56")
    private LocalDateTime submissionTime;

    @ApiModelProperty(value = "工务段所在地海拔高度（米）", required = true, example = "1500")
    private Integer workStationAltitude;

    @ApiModelProperty(value = "工务段名称", required = true, example = "某某工务段")
    private String workStationName;

    @ApiModelProperty(value = "宿舍幢数", required = true, example = "2")
    private Integer dormitoryBuildingNumber;

    @ApiModelProperty(value = "宿舍室数", required = true, example = "305")
    private Integer dormitoryRoomNumber;

    @ApiModelProperty(value = "同室居住人数", required = true, example = "3")
    private Integer dormitoryOccupants;

    @ApiModelProperty(value = "宿舍面积（平方米）", required = true, example = "35.50")
    private BigDecimal dormitoryArea;

    @ApiModelProperty(value = "宿舍窗户可打开面积（平方米）", required = true, example = "12.75")
    private BigDecimal windowOpenArea;

    @ApiModelProperty(value = "宿舍通风情况", required = true, example = "每日开窗通风")
    private String ventilationCondition;

    @ApiModelProperty(value = "上一周白天工作时间段，平均与多少人在同一房间/空间", required = true, example = "5")
    private Integer avgWorkRoomPeople;

    @ApiModelProperty(value = "上一周白天工作时间段，平均与多少人面对面语言交流（1米以内）", required = true, example = "2")
    private Integer avgWorkFaceToFace;

    @ApiModelProperty(value = "上一周白天工作时间段，平均与多少人有肢体接触（如握手）", required = true, example = "1")
    private Integer avgWorkPhysicalContact;

    @ApiModelProperty(value = "上一周早餐时间段，平均与多少人在同一房间/空间", required = true, example = "4")
    private Integer avgBreakfastRoomPeople;

    @ApiModelProperty(value = "上一周早餐时间段，平均与多少人面对面语言交流（1米以内）", required = true, example = "2")
    private Integer avgBreakfastFaceToFace;

    @ApiModelProperty(value = "上一周早餐时间段，平均与多少人有肢体接触（如握手）", required = true, example = "0")
    private Integer avgBreakfastPhysicalContact;

    @ApiModelProperty(value = "上一周午餐时间段，平均与多少人在同一房间/空间", required = true, example = "6")
    private Integer avgLunchRoomPeople;

    @ApiModelProperty(value = "上一周午餐时间段，平均与多少人面对面语言交流（1米以内）", required = true, example = "3")
    private Integer avgLunchFaceToFace;

    @ApiModelProperty(value = "上一周午餐时间段，平均与多少人有肢体接触（如握手）", required = true, example = "1")
    private Integer avgLunchPhysicalContact;

    @ApiModelProperty(value = "上一周晚餐时间段，平均与多少人在同一房间/空间", required = true, example = "5")
    private Integer avgDinnerRoomPeople;

    @ApiModelProperty(value = "上一周晚餐时间段，平均与多少人面对面语言交流（1米以内）", required = true, example = "3")
    private Integer avgDinnerFaceToFace;

    @ApiModelProperty(value = "上一周晚餐时间段，平均与多少人有肢体接触（如握手）", required = true, example = "1")
    private Integer avgDinnerPhysicalContact;

    @ApiModelProperty(value = "上一周共参加几次集体性活动（如开会）", required = true, example = "2")
    private Integer collectiveActivitiesCount;

    @ApiModelProperty(value = "每次集体性活动中，平均与多少人在同一房间/空间", required = true, example = "8")
    private Integer avgActivityRoomPeople;

    @ApiModelProperty(value = "每次集体性活动中，平均与多少人语言交流（1米以内）", required = true, example = "4")
    private Integer avgActivityFaceToFace;

    @ApiModelProperty(value = "每次集体性活动中，平均与多少人有肢体接触（如握手）", required = true, example = "2")
    private Integer avgActivityPhysicalContact;

    @ApiModelProperty(value = "当月平均气压（kPa）", required = true, example = "101.35")
    private BigDecimal avgMonthlyPressure;

    @ApiModelProperty(value = "当月最高气温（℃）", required = true, example = "35.6")
    private BigDecimal maxTemperature;

    @ApiModelProperty(value = "当月最低气温（℃）", required = true, example = "18.2")
    private BigDecimal minTemperature;

    public Integer getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public Integer getWorkStationAltitude() {
        return workStationAltitude;
    }

    public void setWorkStationAltitude(Integer workStationAltitude) {
        this.workStationAltitude = workStationAltitude;
    }

    public String getWorkStationName() {
        return workStationName;
    }

    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    public Integer getDormitoryBuildingNumber() {
        return dormitoryBuildingNumber;
    }

    public void setDormitoryBuildingNumber(Integer dormitoryBuildingNumber) {
        this.dormitoryBuildingNumber = dormitoryBuildingNumber;
    }

    public Integer getDormitoryRoomNumber() {
        return dormitoryRoomNumber;
    }

    public void setDormitoryRoomNumber(Integer dormitoryRoomNumber) {
        this.dormitoryRoomNumber = dormitoryRoomNumber;
    }

    public Integer getDormitoryOccupants() {
        return dormitoryOccupants;
    }

    public void setDormitoryOccupants(Integer dormitoryOccupants) {
        this.dormitoryOccupants = dormitoryOccupants;
    }

    public BigDecimal getDormitoryArea() {
        return dormitoryArea;
    }

    public void setDormitoryArea(BigDecimal dormitoryArea) {
        this.dormitoryArea = dormitoryArea;
    }

    public BigDecimal getWindowOpenArea() {
        return windowOpenArea;
    }

    public void setWindowOpenArea(BigDecimal windowOpenArea) {
        this.windowOpenArea = windowOpenArea;
    }

    public String getVentilationCondition() {
        return ventilationCondition;
    }

    public void setVentilationCondition(String ventilationCondition) {
        this.ventilationCondition = ventilationCondition;
    }

    public Integer getAvgWorkRoomPeople() {
        return avgWorkRoomPeople;
    }

    public void setAvgWorkRoomPeople(Integer avgWorkRoomPeople) {
        this.avgWorkRoomPeople = avgWorkRoomPeople;
    }

    public Integer getAvgWorkFaceToFace() {
        return avgWorkFaceToFace;
    }

    public void setAvgWorkFaceToFace(Integer avgWorkFaceToFace) {
        this.avgWorkFaceToFace = avgWorkFaceToFace;
    }

    public Integer getAvgWorkPhysicalContact() {
        return avgWorkPhysicalContact;
    }

    public void setAvgWorkPhysicalContact(Integer avgWorkPhysicalContact) {
        this.avgWorkPhysicalContact = avgWorkPhysicalContact;
    }

    public Integer getAvgBreakfastRoomPeople() {
        return avgBreakfastRoomPeople;
    }

    public void setAvgBreakfastRoomPeople(Integer avgBreakfastRoomPeople) {
        this.avgBreakfastRoomPeople = avgBreakfastRoomPeople;
    }

    public Integer getAvgBreakfastFaceToFace() {
        return avgBreakfastFaceToFace;
    }

    public void setAvgBreakfastFaceToFace(Integer avgBreakfastFaceToFace) {
        this.avgBreakfastFaceToFace = avgBreakfastFaceToFace;
    }

    public Integer getAvgBreakfastPhysicalContact() {
        return avgBreakfastPhysicalContact;
    }

    public void setAvgBreakfastPhysicalContact(Integer avgBreakfastPhysicalContact) {
        this.avgBreakfastPhysicalContact = avgBreakfastPhysicalContact;
    }

    public Integer getAvgLunchRoomPeople() {
        return avgLunchRoomPeople;
    }

    public void setAvgLunchRoomPeople(Integer avgLunchRoomPeople) {
        this.avgLunchRoomPeople = avgLunchRoomPeople;
    }

    public Integer getAvgLunchFaceToFace() {
        return avgLunchFaceToFace;
    }

    public void setAvgLunchFaceToFace(Integer avgLunchFaceToFace) {
        this.avgLunchFaceToFace = avgLunchFaceToFace;
    }

    public Integer getAvgLunchPhysicalContact() {
        return avgLunchPhysicalContact;
    }

    public void setAvgLunchPhysicalContact(Integer avgLunchPhysicalContact) {
        this.avgLunchPhysicalContact = avgLunchPhysicalContact;
    }

    public Integer getAvgDinnerRoomPeople() {
        return avgDinnerRoomPeople;
    }

    public void setAvgDinnerRoomPeople(Integer avgDinnerRoomPeople) {
        this.avgDinnerRoomPeople = avgDinnerRoomPeople;
    }

    public Integer getAvgDinnerFaceToFace() {
        return avgDinnerFaceToFace;
    }

    public void setAvgDinnerFaceToFace(Integer avgDinnerFaceToFace) {
        this.avgDinnerFaceToFace = avgDinnerFaceToFace;
    }

    public Integer getAvgDinnerPhysicalContact() {
        return avgDinnerPhysicalContact;
    }

    public void setAvgDinnerPhysicalContact(Integer avgDinnerPhysicalContact) {
        this.avgDinnerPhysicalContact = avgDinnerPhysicalContact;
    }

    public Integer getCollectiveActivitiesCount() {
        return collectiveActivitiesCount;
    }

    public void setCollectiveActivitiesCount(Integer collectiveActivitiesCount) {
        this.collectiveActivitiesCount = collectiveActivitiesCount;
    }

    public Integer getAvgActivityRoomPeople() {
        return avgActivityRoomPeople;
    }

    public void setAvgActivityRoomPeople(Integer avgActivityRoomPeople) {
        this.avgActivityRoomPeople = avgActivityRoomPeople;
    }

    public Integer getAvgActivityFaceToFace() {
        return avgActivityFaceToFace;
    }

    public void setAvgActivityFaceToFace(Integer avgActivityFaceToFace) {
        this.avgActivityFaceToFace = avgActivityFaceToFace;
    }

    public Integer getAvgActivityPhysicalContact() {
        return avgActivityPhysicalContact;
    }

    public void setAvgActivityPhysicalContact(Integer avgActivityPhysicalContact) {
        this.avgActivityPhysicalContact = avgActivityPhysicalContact;
    }

    public BigDecimal getAvgMonthlyPressure() {
        return avgMonthlyPressure;
    }

    public void setAvgMonthlyPressure(BigDecimal avgMonthlyPressure) {
        this.avgMonthlyPressure = avgMonthlyPressure;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }
}
