package com.infect.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.entity.Satisfactionrating;
import com.infect.entity.Satisfactionsurvey;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.ISatisfactionratingService;
import com.infect.service.ISatisfactionsurveyService;
import com.infect.vo.system.SatisfactionNumberInfoVO;
import com.infect.vo.system.SatisfactionsurveyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "满意度调查相关接口")
@RestController
@RequestMapping("/admin/satisfaction")
public class SystemSatisfactionController {

    @Autowired
    private ISatisfactionsurveyService satisfactionsurveyService;

    @Autowired
    private ISatisfactionratingService satisfactionratingService;

    @PostMapping("/addSatisfactionSurvey")
    @ApiOperation("添加满意度调查")
    public Result addSatisfactionSurvey(@RequestBody Satisfactionsurvey satisfactionsurvey){
        satisfactionsurveyService.save(satisfactionsurvey);
        return Result.success();
    }

    @GetMapping("/pageSelectSatisfactionSurvey")
    @ApiOperation("分页查询满意度调查列表（注意满意度计算）")
    public Result<PageResult<SatisfactionsurveyVO>> pageSelectSatisfactionSurvey(Integer pageNo, Integer pageNumber){
        PageResult<SatisfactionsurveyVO> pageResult = satisfactionsurveyService.pageSelectSatisfactionSurvey(pageNo,pageNumber);
        return Result.success(pageResult);
    }

    @PutMapping("/openSatisfaction/{surveyID}")
    @ApiOperation("根据ID开放满意度调查")
    public Result openSatisfaction(@PathVariable Integer surveyID){
        boolean b = satisfactionsurveyService.openSatisfaction(surveyID);
        if (!b){
            return Result.error("有其他满意度调查正在开启中...");
        }
        return Result.success();
    }

    @PutMapping("/closeSatisfaction/{surveyID}")
    @ApiOperation("根据ID关闭满意度调查")
    public Result closeSatisfaction(@PathVariable Integer surveyID){
        Satisfactionsurvey satisfactionsurvey = new Satisfactionsurvey();
        satisfactionsurvey.setSurveyID(surveyID);
        satisfactionsurvey.setIsOpen(false);
        satisfactionsurveyService.updateById(satisfactionsurvey);
        return Result.success();
    }

    @GetMapping("/pageSelectSatisfactionRating")
    @ApiOperation("分页查询满意度打分列表")
    public Result<PageResult<Satisfactionrating>> pageSelectSatisfactionRating(Integer pageNo, Integer pageNumber, Integer surveyID){
        Page<Satisfactionrating> page = Page.of(pageNo,pageNumber);
        page.addOrder(new OrderItem("RatingTime", false));

        Page<Satisfactionrating> p = satisfactionratingService.page(page,new LambdaQueryWrapper<Satisfactionrating>().eq(Satisfactionrating::getSurveyID,surveyID));

        PageResult<Satisfactionrating> pageResult = new PageResult<>();
        pageResult.setTotal(p.getTotal());
        pageResult.setRecords(p.getRecords());

        return Result.success(pageResult);
    }

    @GetMapping("/getNumberInfo/{surveyID}")
    @ApiOperation("统计满意度打分人数信息")
    public Result<SatisfactionNumberInfoVO> getNumberInfo(@PathVariable Integer surveyID){
        SatisfactionNumberInfoVO numberInfo = satisfactionsurveyService.getNumberInfo(surveyID);
        return Result.success(numberInfo);
    }
}
