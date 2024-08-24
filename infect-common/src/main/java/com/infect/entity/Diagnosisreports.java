package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
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
@TableName("diagnosisreports")
@ApiModel(value="Diagnosisreports对象", description="")
public class Diagnosisreports implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ReportID", type = IdType.AUTO)
    private Integer ReportID;

    private Integer DiagnosisResultsID;

    private String ReportType;

    private Blob File;

    private String FileName;

    private String FileType;

    private LocalDateTime UploadDate;


}
