package com.infect.controller.cdcStaff;

import cn.hutool.core.lang.Pair;
import com.infect.dto.system.DiseaseStatisticsDTO;
import com.infect.result.Result;
import com.infect.service.MyDiagnosisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "统计报表-疾病统计报表")
@RestController
@RequestMapping("/cdcStaff/statisticsDisease")
public class StatisticsDiseaseController {

    @Autowired
    private MyDiagnosisService diagnosisService;

    @GetMapping("/getDiseaseType")
    @ApiOperation("查询疾病类型")
    public Result<List<String>> getDiseaseType(){
        return Result.success(diagnosisService.getDiseaseList());
    }

    @GetMapping("getDiseaseStatisticsListInfo")
    @ApiOperation("根据时间，数据类型，疾病类型查询数据")
    public Result<Map<String,List<Pair<LocalDate,Integer>>>> getDiseaseStatisticsListInfo(DiseaseStatisticsDTO diseaseStatisticsDTO){
        if(diseaseStatisticsDTO.getDiseaseList() == null
                || diseaseStatisticsDTO.getDiseaseList().isEmpty()
                || diseaseStatisticsDTO.getSourceType()==null
                || (!diseaseStatisticsDTO.getSourceType().equals(DiseaseStatisticsDTO.AUTOMATIC_DIAGNOSIS)) && !diseaseStatisticsDTO.getSourceType().equals(DiseaseStatisticsDTO.HOSPITAL_DIAGNOSIS)){
            return Result.error("未设置查询数据");
        }
        Map<String,List<Pair<LocalDate,Integer>>> map = diagnosisService.getDiseaseStatisticsListInfo(diseaseStatisticsDTO);
        return Result.success(map);
    }
}
