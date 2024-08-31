package com.infect.service;

import com.infect.entity.Diagnosisexaminations;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IDiagnosisexaminationsService extends IService<Diagnosisexaminations> {

    void saveDiagnosisExaminations(Integer userId, Diagnosisexaminations diagnosisexaminations);
}
