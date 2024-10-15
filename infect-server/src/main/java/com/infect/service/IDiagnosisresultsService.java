package com.infect.service;

import com.infect.dto.DiagnosisResultsEmpDTO;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.entity.Diagnosisresults;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.DiagnosisPageVO;

import java.time.LocalDate;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IDiagnosisresultsService extends IService<Diagnosisresults> {

    void saveDiagnosisResult(DiagnosisResultsEmpDTO diagnosisResultsEmpDTO, Integer userId, Integer submissionUserId);

    Diagnosisresults getDiagnosisResult(LocalDate date, Integer userId);

    PageResult<DiagnosisPageVO> pageSelectDiagnosis(DiagnosisPageDTO diagnosisPageDTO);
}
