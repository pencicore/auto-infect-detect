package com.infect.controller.systemUser;

import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.ILabtestreportService;
import com.infect.vo.system.LabTestPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "检查信息管理")
@RestController
@RequestMapping("/systemUser/labTestManager")
public class LabTestManagerController {

    @Autowired
    private ILabtestreportService labtestreportService;

    @PostMapping("/pageSelectLabTest")
    @ApiOperation(value = "根据用户名，电话，部门，时间分页查询用户检查信息")
    public Result<PageResult<LabTestPageVO>> pageSelectLabTest(@RequestBody DiagnosisPageDTO labTestPageDTO){
        PageResult<LabTestPageVO> pageResult = labtestreportService.pageSelectLabTest(labTestPageDTO);
        return Result.success(pageResult);
    }

}
