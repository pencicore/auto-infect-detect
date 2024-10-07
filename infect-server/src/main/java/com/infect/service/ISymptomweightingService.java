package com.infect.service;

import com.infect.dto.system.UpdateBatchWeightScoringDTO;
import com.infect.entity.Symptomweighting;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-26
 */
public interface ISymptomweightingService extends IService<Symptomweighting> {

    void putValueDataByExcel(MultipartFile multipartFile) throws Exception;

    void getExcelInitialWeightScoringTableForInfectiousDiseases(HttpServletResponse response);

    boolean updateBatchWeightScoring(List<UpdateBatchWeightScoringDTO> updateDTOList);
}
