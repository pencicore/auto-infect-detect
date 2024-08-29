package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.DiagnosisResultsEmpDTO;
import com.infect.entity.Diagnosisresults;
import com.infect.entity.User;
import com.infect.mapper.DiagnosisresultsMapper;
import com.infect.mapper.UserMapper;
import com.infect.service.IDiagnosisresultsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DiagnosisresultsServiceImpl extends ServiceImpl<DiagnosisresultsMapper, Diagnosisresults> implements IDiagnosisresultsService {

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

    @Autowired
    private UserMapper userMapper;

    //提交确诊疾病信息
    @Override
    public void saveDiagnosisResult(DiagnosisResultsEmpDTO diagnosisResultsEmpDTO, Integer userId, Integer submissionUserId) {
        //查询是否已有诊断结果数据,已有，则直接返回
        if (lambdaQuery()
                .eq(Diagnosisresults::getSubmissionTime, LocalDate.now())
                .eq(Diagnosisresults::getUserId, userId)
                .count() != 0) {
            return;
        }

        //将dto中的数据复制到entity实体类中
        Diagnosisresults diagnosisresults = BeanUtil.copyProperties(diagnosisResultsEmpDTO, Diagnosisresults.class);

        //设置用户id，提交时间，提交用户类型
        diagnosisresults.setUserId(userId);
        diagnosisresults.setSubmissionUserId(submissionUserId);
        diagnosisresults.setSubmissionTime(LocalDate.now());

        //通过用户id，获取提交用户姓名对象，并设置提交用户名，提交用户类型
        //TODO 后期想办法在这里只获取用户名
        User user = userMapper.selectById(submissionUserId);
        diagnosisresults.setSubmissionUserName(user.getName());
        diagnosisresults.setSubmissionUserType(user.getUserType());

        diagnosisresultsMapper.insert(diagnosisresults);
    }

    @Override
    public Diagnosisresults getDiagnosisResult(LocalDate date, Integer userId) {
        return lambdaQuery()
                .eq(Diagnosisresults::getSubmissionTime, date)
                .eq(Diagnosisresults::getSubmissionUserId, userId)
                .one();
    }
}
