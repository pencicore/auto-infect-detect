package com.infect.controller.systemUser;

import com.infect.dto.system.UserFeedBackPageDTO;
import com.infect.entity.Userfeedback;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IUserfeedbackService;
import com.infect.vo.system.UserFeedBackPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户反馈相关接口")
@RestController
@RequestMapping("/systemUser/feedBackManager")
public class FeedBackManagerController {

    @Autowired
    private IUserfeedbackService userfeedbackService;

    @PostMapping("/pageSelectFeedBack")
    @ApiOperation("根据用户名，联系电话，标题分页查询用户反馈信息")
    public Result<PageResult<UserFeedBackPageVO>> pageSelectFeedBack(@RequestBody UserFeedBackPageDTO userFeedBackPageDTO){
        PageResult<UserFeedBackPageVO> pageResult = userfeedbackService.pageSelectFeedBack(userFeedBackPageDTO);
        return Result.success(pageResult);
    }

    @GetMapping("getUserFeedBack/{feedbackId}")
    @ApiOperation("根据反馈id查询反馈信息")
    public Result<Userfeedback> getUserFeedBack(@PathVariable Integer feedbackId){
        return Result.success(
            userfeedbackService.getById(feedbackId)
        );
    }

    @GetMapping("getExcelUserFeedbackInformationExportTable")
    @ApiOperation("导出文件：导出用户反馈信息导出表")
    public void getExcelUserFeedbackInformationExportTable(HttpServletResponse response){
        userfeedbackService.getExcelUserFeedbackInformationExportTable(response);
    }

}
