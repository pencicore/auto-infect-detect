package com.infect.service;

import com.infect.entity.Systemsettings;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-25
 */
public interface ISystemsettingsService extends IService<Systemsettings> {

    void systemChangExpertOrAI(Boolean isAI);
}
