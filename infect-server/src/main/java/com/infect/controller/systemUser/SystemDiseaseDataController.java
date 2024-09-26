package com.infect.controller.systemUser;

import com.infect.dto.system.DiseaseTypePageDTO;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IDiseasetypeService;
import com.infect.vo.system.DiseaseTypePageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "系统管理-疾病基础数据管理")
@RestController
@RequestMapping("/systemUser/systemDiseaseData")
public class SystemDiseaseDataController {

    @Autowired
    private IDiseasetypeService diseasetypeService;

    @PostMapping("/pageSelectDiseaseType")
    @ApiOperation("分页查询疾病基础信息")
    public Result<PageResult<DiseaseTypePageVO>> pageSelectDiseaseType(@RequestBody DiseaseTypePageDTO diseaseTypePageDTO){
        PageResult<DiseaseTypePageVO> pageResult = diseasetypeService.pageSelectDiseaseType(diseaseTypePageDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/getExcelDiseaseBasicDataExportTable")
    @ApiOperation("导出文件：导出疾病基础数据导出表")
    public void getExcelDiseaseBasicDataExportTable(HttpServletResponse response){
        diseasetypeService.getExcelDiseaseBasicDataExportTable(response);
    }

}
