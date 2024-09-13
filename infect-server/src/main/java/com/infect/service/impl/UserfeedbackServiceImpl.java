package com.infect.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.entity.Userfeedback;
import com.infect.mapper.UserfeedbackMapper;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IUserfeedbackService;
import org.springframework.stereotype.Service;

@Service
public class UserfeedbackServiceImpl extends ServiceImpl<UserfeedbackMapper, Userfeedback> implements IUserfeedbackService {

}
