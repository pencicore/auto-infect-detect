package com.infect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.entity.Diagnosisexaminations;
import com.infect.entity.Diagnosisresults;
import com.infect.mapper.DiagnosisexaminationsMapper;
import com.infect.mapper.DiagnosisresultsMapper;
import com.infect.service.IDiagnosisexaminationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DiagnosisexaminationsServiceImpl extends ServiceImpl<DiagnosisexaminationsMapper, Diagnosisexaminations> implements IDiagnosisexaminationsService {

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

    @Autowired
    private DiagnosisexaminationsMapper diagnosisexaminationsMapper;

    @Override
    public void saveDiagnosisExaminations(Integer userId, Diagnosisexaminations diagnosisexaminations) {
        //获取诊断结果id
        LambdaQueryWrapper<Diagnosisresults> wrapper = new LambdaQueryWrapper<Diagnosisresults>()
                .eq(Diagnosisresults::getUserId, userId)
                .eq(Diagnosisresults::getSubmissionTime, LocalDate.now());
        Integer diagnosisResultId = diagnosisresultsMapper.selectOne(wrapper).getDiagnosisResultsId();

        //如果字段结果id为null，直接退出
        if (diagnosisResultId == null) {
            return;
        }

        //查询数据库中是否已有对应数据，避免重复提交
        Long count = lambdaQuery()
                .eq(Diagnosisexaminations::getDiagnosisResultsId, diagnosisResultId)
                .count();
        if (count != 0) {
            return;
        }

        //向数据库中添加数据
        diagnosisexaminations.setDiagnosisResultsId(diagnosisResultId);
        diagnosisexaminationsMapper.insert(diagnosisexaminations);
    }
}
