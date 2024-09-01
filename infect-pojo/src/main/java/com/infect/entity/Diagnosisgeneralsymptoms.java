package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosisgeneralsymptoms")
@ApiModel(value = "DiagnosisGeneralSymptoms对象", description = "诊断全身症状表")
public class Diagnosisgeneralsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "全身症状ID", hidden = true)
    @TableId(value = "DiagnosisGeneralSymptomID", type = IdType.AUTO)
    private Integer diagnosisGeneralSymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否发热", example = "true", required = true)
    private Boolean hasFever;

    @ApiModelProperty(value = "最高体温（℃）", example = "39.5", required = true)
    private BigDecimal highestTemperature;

    @ApiModelProperty(value = "发热持续时间（小时）", example = "48", required = true)
    private Integer feverDuration;

    @ApiModelProperty(value = "是否寒战", example = "false", required = true)
    private Boolean hasChills;

    @ApiModelProperty(value = "是否大汗", example = "true", required = true)
    private Boolean hasSweating;

    @ApiModelProperty(value = "是否乏力", example = "true", required = true)
    private Boolean hasFatigue;

    @ApiModelProperty(value = "是否头痛", example = "false", required = true)
    private Boolean hasHeadache;

    @ApiModelProperty(value = "是否肌肉酸痛", example = "true", required = true)
    private Boolean hasMusclePain;

    @ApiModelProperty(value = "是否关节酸痛", example = "true", required = true)
    private Boolean hasJointPain;

    @ApiModelProperty(value = "是否淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwelling;

    @ApiModelProperty(value = "腹股沟淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingGroin;

    @ApiModelProperty(value = "腋下淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingArmpit;

    @ApiModelProperty(value = "锁骨下淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingSubclavian;

    @ApiModelProperty(value = "颈部淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingNeck;

    @ApiModelProperty(value = "肘部淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingElbow;

    @ApiModelProperty(value = "腘窝淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingPopliteal;

    @ApiModelProperty(value = "是否口唇、颜面、四肢及全身皮肤发绀", example = "false", required = true)
    private Boolean hasCyanosis;

    @ApiModelProperty(value = "是否皮下及黏膜出血或出血点", example = "true", required = true)
    private Boolean hasSubcutaneousAndMucosalBleedingSpots;

    @ApiModelProperty(value = "是否严重贫血", example = "false", required = true)
    private Boolean hasSevereAnemia;

    @ApiModelProperty(value = "是否皮肤可见剧痛的红色丘疹", example = "true", required = true)
    private Boolean hasPainfulRedRash;

    @ApiModelProperty(value = "是否皮肤可见周边呈灰黑色、基底坚硬的血性水泡", example = "false", required = true)
    private Boolean hasBloodBlisters;

    @ApiModelProperty(value = "是否皮肤出现呈灰黑色创面的溃疡", example = "true", required = true)
    private Boolean hasSkinUlcer;

    @ApiModelProperty(value = "是否皮下及黏膜出血腔道出血", example = "false", required = true)
    private Boolean hasSubcutaneousAndMucosalBleedingCavity;

    @ApiModelProperty(value = "皮疹：充血性或点状出血疹", example = "true", required = true)
    private Boolean hasCongestiveOrPetechialRash;

    @ApiModelProperty(value = "是否失水", example = "true", required = true)
    private Boolean hasDehydration;

    @ApiModelProperty(value = "失水程度", example = "中度", required = true)
    private String dehydrationSeverity;

    @ApiModelProperty(value = "是否瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean hasItchyRash;

    @ApiModelProperty(value = "手指瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnFingers;

    @ApiModelProperty(value = "手背瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnBackOfHands;

    @ApiModelProperty(value = "上肢瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnUpperLimbs;

    @ApiModelProperty(value = "下肢瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnLowerLimbs;

    @ApiModelProperty(value = "足背瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnFeet;

    @ApiModelProperty(value = "面部瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnFace;

    @ApiModelProperty(value = "其他部位瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnOther;

    @ApiModelProperty(value = "是否水肿", example = "true", required = true)
    private Boolean hasEdema;

    @ApiModelProperty(value = "是否盗汗", example = "false", required = true)
    private Boolean hasNightSweats;

    @ApiModelProperty(value = "是否消瘦", example = "true", required = true)
    private Boolean hasWeightLoss;

    @ApiModelProperty(value = "是否虚脱/全身无力", example = "false", required = true)
    private Boolean hasExhaustion;

    @ApiModelProperty(value = "是否白细胞明显增高", example = "true", required = true)
    private Boolean hasWhiteBloodCells;

    @ApiModelProperty(value = "是否血压下降", example = "true", required = true)
    private Boolean hasBloodPressureDrop;

    @ApiModelProperty(value = "最低血压（mmHg）", example = "80", required = true)
    private Integer lowestBloodPressure;

    @ApiModelProperty(value = "是否休克症候群", example = "false", required = true)
    private Boolean hasShockSyndrome;

    @ApiModelProperty(value = "是否颅压高", example = "true", required = true)
    private Boolean hasHighIntracranialPressure;

    @ApiModelProperty(value = "是否脑脊液浊浑", example = "true", required = true)
    private Boolean hasTurbidCerebrospinalFluid;

    @ApiModelProperty(value = "是否出血", example = "false", required = true)
    private Boolean hasBleeding;

    @ApiModelProperty(value = "出血量（ml）", example = "500", required = true)
    private Integer bleedingVolume;

    @ApiModelProperty(value = "出血腔道", example = "口腔", required = true)
    private String bleedingCavity;

    @ApiModelProperty(value = "是否血浆渗漏表现", example = "true", required = true)
    private Boolean hasPlasmaLeakage;

    @ApiModelProperty(value = "是否其他重要脏器损伤", example = "false", required = true)
    private Boolean hasOtherOrganDamage;

    @ApiModelProperty(value = "是否Kernig征", example = "true", required = true)
    private Boolean hasKernigSign;

    @ApiModelProperty(value = "是否Brudzinski征", example = "true", required = true)
    private Boolean hasBrudzinskiSign;
}
