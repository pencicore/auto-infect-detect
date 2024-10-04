package com.infect.controller.cdcStaff;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.system.DiseaseLearningMaterialsPageDTO;
import com.infect.dto.system.LearningMaterialDTO;
import com.infect.dto.system.LearningMaterialUpdateDTO;
import com.infect.entity.Diseaselearningmaterials;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IDiseaselearningmaterialsService;
import com.infect.vo.LearningMaterialVO;
import com.infect.vo.system.DiseaseLearningMaterialsPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "宣传资料管理")
@RestController
@RequestMapping("/cdcStaff/promotionalMaterialsManager")
public class PromotionalMaterialsManagerController {

    @Autowired
    private IDiseaselearningmaterialsService diseaselearningmaterialsService;

    @ApiOperation("根据疾病类型名，分页查询疾病防控宣传资料")
    @PostMapping("pageSelectDiseaseLearningMaterials")
    public Result<PageResult<DiseaseLearningMaterialsPageVO>> pageSelectDiseaseLearningMaterials(@RequestBody DiseaseLearningMaterialsPageDTO diseaseLearningMaterialsPageDTO){
        PageResult<DiseaseLearningMaterialsPageVO> pageResult = diseaselearningmaterialsService.pageSelectDiseaseLearningMaterials(diseaseLearningMaterialsPageDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("添加疾病防控宣传资料（包含文件）")
    @PostMapping("saveMaterial")
    public Result saveMaterial(@ModelAttribute LearningMaterialDTO learningMaterialDTO){
        diseaselearningmaterialsService.saveMaterial(learningMaterialDTO);
        return Result.success();
    }

    @ApiOperation("根据id获取疾病防控宣传资料")
    @GetMapping("getMaterialById/{materialId}")
    public Result<LearningMaterialVO> getMaterialById(@PathVariable Integer materialId){
        return Result.success(
                BeanUtil.copyProperties(
                        diseaselearningmaterialsService.lambdaQuery()
                                .eq(Diseaselearningmaterials::getMaterialId, materialId)
                                .eq(Diseaselearningmaterials::getIsDeleted, false)
                                .one(),
                        LearningMaterialVO.class
                )
        );
    }

    @ApiOperation("根据id修改疾病防控宣传资料")
    @PostMapping("updateMaterialById")
    public Result updateMaterialById(@RequestBody LearningMaterialUpdateDTO learningMaterialUpdateDTO){
        diseaselearningmaterialsService.updateMaterialById(learningMaterialUpdateDTO);
        return Result.success();
    }

    @ApiOperation("禁用/启用疾病防控宣传资料")
    @PutMapping("startOrStopMaterial")
    public Result startOrStopMaterial(Integer materialId, Boolean isDelete){
        diseaselearningmaterialsService.startOrStopMaterial(materialId,isDelete);
        return Result.success();
    }

    @ApiOperation("根据id，升/降序，交换排序顺序")
    @PutMapping("upOrdownMaterialSequenceNumber")
    public Result upOrdownMaterialSequenceNumber(Integer sequenceNumber, Boolean isUp){
        diseaselearningmaterialsService.upOrdownMaterialSequenceNumber(sequenceNumber, isUp);
        return Result.success();
    }

}
