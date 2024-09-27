package com.infect.controller.systemUser;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.dto.system.UpdateBatchWeightScoringDTO;
import com.infect.entity.Symptomweighting;
import com.infect.result.Result;
import com.infect.service.ISymptomweightingService;
import com.infect.vo.system.SymptomweightingVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "系统管理-权重管理")
@RestController
@RequestMapping("/systemUser/systemValueManager")
public class SystemValueManagerController {

    @Autowired
    private ISymptomweightingService symptomweightingService;

    @ApiOperation("导入数据：将传染病初始权重打分表加工导入到数据库中")
    @PostMapping("/putValueDataByExcel")
    public Result putValueDataByExcel(@RequestParam("file") MultipartFile file) {
        try {
            symptomweightingService.putValueDataByExcel(file);
        } catch (Exception e) {
            return Result.error("文件错误");
        }
        return Result.success();
    }

    @ApiOperation("导出文件：传染病初始权重打分表加工")
    @GetMapping("/getExcelInitialWeightScoringTableForInfectiousDiseases")
    public void getExcelInitialWeightScoringTableForInfectiousDiseases(HttpServletResponse response){
        symptomweightingService.getExcelInitialWeightScoringTableForInfectiousDiseases(response);
    }

    @ApiOperation("根据疾病名查询疾病权重信息")
    @GetMapping("/getAllWeightScoringInfo")
    public Result<List<SymptomweightingVO>> getAllWeightScoringInfo(String diseaseTypeName){
        List<Symptomweighting> list = symptomweightingService.list(
                new LambdaQueryWrapper<Symptomweighting>()
                        .eq(Symptomweighting::getDiseaseTypeName, diseaseTypeName)
        );
        return Result.success(
                BeanUtil.copyToList(list,SymptomweightingVO.class)
        );
    }

    @ApiOperation("根据疾病id批量更新疾病权重信息")
    @PostMapping("/updateBatchWeightScoring")
    public Result updateBatchWeightScoring(@RequestBody List<UpdateBatchWeightScoringDTO> updateDTOList){
        symptomweightingService.updateBatchWeightScoring(updateDTOList);
        return Result.success();
    }

}
