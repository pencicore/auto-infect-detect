package com.infect.service;

import com.infect.entity.Satisfactionsurvey;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.SatisfactionsurveyEmplyeeVO;
import com.infect.vo.system.SatisfactionNumberInfoVO;
import com.infect.vo.system.SatisfactionsurveyVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
public interface ISatisfactionsurveyService extends IService<Satisfactionsurvey> {

    PageResult<SatisfactionsurveyVO> pageSelectSatisfactionSurvey(Integer pageNo, Integer pageNumber);

    boolean openSatisfaction(Integer surveyID);

    SatisfactionNumberInfoVO getNumberInfo(Integer surveyID);

    SatisfactionsurveyEmplyeeVO getIsNeedRating(Integer userID);
}
