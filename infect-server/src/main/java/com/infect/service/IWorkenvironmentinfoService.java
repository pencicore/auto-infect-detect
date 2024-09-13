package com.infect.service;

import com.infect.dto.system.EnvironmentPageDTO;
import com.infect.entity.Workenvironmentinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.EnvironmentInfoVO;

import javax.servlet.http.HttpServletResponse;

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

    Workenvironmentinfo getWorkInfoById(Integer workId);

    PageResult<EnvironmentInfoVO> pageSelectWorkEnvironment(EnvironmentPageDTO environmentPageDTO);

    void queryAllWorkEnvironmentInfoToExcel(HttpServletResponse response);
    
    void updateWorkEnvironmentInfo(Workenvironmentinfo workenvironmentinfo);

    Workenvironmentinfo getEnvironmentInfo(Integer currentId, String date);
}
