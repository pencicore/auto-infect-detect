package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosisreports implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ReportID", type = IdType.AUTO)
    private Integer reportId;

    private Integer diagnosisResultsId;

    private String reportType;

//    private Blob file;

    private String fileName;

    private String filePath;

    private String fileType;

    private LocalDateTime uploadDate;
}
