package com.infect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.entity.Diagnosisresults;
import com.infect.entity.Labtestfiles;
import com.infect.entity.Labtestreport;
import com.infect.entity.User;
import com.infect.mapper.LabtestfilesMapper;
import com.infect.mapper.UserMapper;
import com.infect.result.PageResult;
import com.infect.service.ILabtestfilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.vo.system.LabTestPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-22
 */
@Service
public class LabtestfilesServiceImpl extends ServiceImpl<LabtestfilesMapper, Labtestfiles> implements ILabtestfilesService {

}
