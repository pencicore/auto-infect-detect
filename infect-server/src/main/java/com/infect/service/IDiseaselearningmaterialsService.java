package com.infect.service;

import com.infect.dto.system.DiseaseLearningMaterialsPageDTO;
import com.infect.dto.system.LearningMaterialDTO;
import com.infect.dto.system.LearningMaterialUpdateDTO;
import com.infect.entity.Diseaselearningmaterials;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.DiseaseLearningMaterialsPageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-10-02
 */
public interface IDiseaselearningmaterialsService extends IService<Diseaselearningmaterials> {

    PageResult<DiseaseLearningMaterialsPageVO> pageSelectDiseaseLearningMaterials(DiseaseLearningMaterialsPageDTO diseaseLearningMaterialsPageDTO);

    void saveMaterial(LearningMaterialDTO learningMaterialDTO);

    void updateMaterialById(LearningMaterialUpdateDTO learningMaterialUpdateDTO);

    boolean startOrStopMaterial(Integer materialId, Boolean isDelete);

    boolean upOrdownMaterialSequenceNumber(Integer sequenceNumber, Boolean isUp);
}
