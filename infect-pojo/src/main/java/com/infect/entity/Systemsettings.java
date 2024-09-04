package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-08-25
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("systemsettings")
@ApiModel(value="Systemsettings对象", description="")
public class Systemsettings implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean isAI;

    public Boolean getAI() {
        return isAI;
    }

    public void setAI(Boolean AI) {
        isAI = AI;
    }
}
