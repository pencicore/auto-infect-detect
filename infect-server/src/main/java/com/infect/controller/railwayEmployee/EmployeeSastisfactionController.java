package com.infect.controller.railwayEmployee;

import com.infect.entity.Satisfactionrating;
import com.infect.result.Result;
import com.infect.service.ISatisfactionratingService;
import com.infect.service.ISatisfactionsurveyService;
import com.infect.utils.BaseContext;
import com.infect.vo.SatisfactionsurveyEmplyeeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Api(tags = "满意度调查相关接口")
@RestController
@RequestMapping("/railwayemployee/satisfaction")
public class EmployeeSastisfactionController {

    @Autowired
    private ISatisfactionsurveyService satisfactionsurveyService;

    @Autowired
    private ISatisfactionratingService satisfactionratingService;

    @ApiOperation("查询是否需要填写满意度打分信息")
    @GetMapping("/getIsNeedRating")
    public Result<SatisfactionsurveyEmplyeeVO> getIsNeedRating(){
        SatisfactionsurveyEmplyeeVO res = satisfactionsurveyService.getIsNeedRating(BaseContext.getCurrentId());
        return Result.success(res);
    }

    @ApiOperation("提交满意度打分信息")
    @PostMapping("/submissionSatisfaction")
    public Result submissionSatisfaction(@RequestBody Satisfactionrating satisfactionrating){
        satisfactionrating.setRatingTime(LocalDateTime.now());
        satisfactionratingService.save(satisfactionrating);
        return Result.success();
    }

}
