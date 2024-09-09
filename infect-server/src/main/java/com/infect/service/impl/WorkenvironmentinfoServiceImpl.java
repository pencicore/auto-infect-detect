package com.infect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.entity.Workenvironmentinfo;
import com.infect.mapper.WorkenvironmentinfoMapper;
import com.infect.service.IWorkenvironmentinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class WorkenvironmentinfoServiceImpl extends ServiceImpl<WorkenvironmentinfoMapper, Workenvironmentinfo> implements IWorkenvironmentinfoService {

    @Autowired
    private WorkenvironmentinfoMapper workenvironmentinfoMapper;

    //提交或修改当月工作环境信息
    @Override
    public void saveWorkEnvironmentInfo(Workenvironmentinfo workenvironmentinfo) {
        //获取今天的年月
        String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));

        //构造查询条件
        LambdaQueryWrapper<Workenvironmentinfo> wrapper = new LambdaQueryWrapper<Workenvironmentinfo>()
                .eq(Workenvironmentinfo::getUserId, BaseContext.getCurrentId())
                .eq(Workenvironmentinfo::getYearMonth, yearMonth);

        //查询是否已经有当月工作环境信息
        Long count = workenvironmentinfoMapper.selectCount(wrapper);

        //为workenvironmentinfo修改年月，用户数据，提交时间，防止有人居心叵测
        workenvironmentinfo.setEnvironmentId(null);
        workenvironmentinfo.setUserId(BaseContext.getCurrentId());
        workenvironmentinfo.setYearMonth(yearMonth);
        workenvironmentinfo.setSubmissionTime(LocalDateTime.now());

        //如果没有添加数据
        if (count == 0) {
            workenvironmentinfoMapper.insert(workenvironmentinfo);
        }
        //如果有修改数据
        if (count == 1) {
            workenvironmentinfoMapper.update(workenvironmentinfo, wrapper);
        }
    }

    //根据用户id和年月查询工作环境信息
    @Override
    public Workenvironmentinfo getWorkEnvironmentInfo(Integer userId, String yearMonth) {
        return lambdaQuery()
                .eq(Workenvironmentinfo::getUserId, userId)
                .eq(Workenvironmentinfo::getYearMonth, yearMonth)
                .one();
    }

    /**
     * 根据id查询用户某月工作环境基本信息
     * @return
     */
    @Override
    public Workenvironmentinfo getWorkInfoById(Integer workId) {
        return lambdaQuery()
                .eq(Workenvironmentinfo::getEnvironmentId, workId)
                .one();
    }
}
