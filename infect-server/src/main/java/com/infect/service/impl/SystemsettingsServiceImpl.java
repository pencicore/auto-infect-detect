package com.infect.service.impl;

import com.infect.entity.Systemsettings;
import com.infect.mapper.SystemsettingsMapper;
import com.infect.service.ISystemsettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-25
 */
@Service
public class SystemsettingsServiceImpl extends ServiceImpl<SystemsettingsMapper, Systemsettings> implements ISystemsettingsService {

    @Autowired
    private SystemsettingsMapper systemsettingsMapper;

    @Override
    public void systemChangExpertOrAI(Boolean isAI) {
        systemsettingsMapper.systemChangExpertOrAI(isAI);
    }
}
