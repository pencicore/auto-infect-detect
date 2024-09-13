package com.infect.service;

import com.infect.entity.Workenvironmentinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IWorkenvironmentinfoService extends IService<Workenvironmentinfo> {

    void saveWorkEnvironmentInfo(Workenvironmentinfo workenvironmentinfo);

    Workenvironmentinfo getWorkEnvironmentInfo(Integer currentId, String yearMonth);

    void updateWorkEnvironmentInfo(Workenvironmentinfo workenvironmentinfo);

    Workenvironmentinfo getEnvironmentInfo(Integer currentId, String date);
}
