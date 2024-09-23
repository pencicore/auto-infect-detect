package com.infect.service;

import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.entity.Labtestreport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.LabTestPageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-23
 */
public interface ILabtestreportService extends IService<Labtestreport> {

    PageResult<LabTestPageVO> pageSelectLabTest(DiagnosisPageDTO labTestPageDTO);

}
