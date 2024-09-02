package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("labtestfiles")
@ApiModel(value="Labtestfiles对象", description="")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Labtestfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FileID", type = IdType.AUTO)
    private Integer fileId;

    private Integer labTestReportId;

    private String specimenType;

    private String fileType;

    private String fileName;

    private String filePath;

}
