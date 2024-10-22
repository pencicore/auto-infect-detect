package com.infect.service;

import com.infect.dto.system.UserFeedBackPageDTO;
import com.infect.entity.Userfeedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.UserFeedBackPageVO;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IUserfeedbackService extends IService<Userfeedback> {

    PageResult<UserFeedBackPageVO> pageSelectFeedBack(UserFeedBackPageDTO userFeedBackPageDTO);

    void getExcelUserFeedbackInformationExportTable(HttpServletResponse response);
}
