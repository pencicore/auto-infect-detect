package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.entity.Satisfactionrating;
import com.infect.entity.Satisfactionsurvey;
import com.infect.enums.SatisfactionLevelEnumConstants;
import com.infect.mapper.SatisfactionratingMapper;
import com.infect.mapper.SatisfactionsurveyMapper;
import com.infect.result.PageResult;
import com.infect.service.ISatisfactionsurveyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.temporary.SatisfactionPairTemp;
import com.infect.vo.SatisfactionsurveyEmplyeeVO;
import com.infect.vo.system.SatisfactionNumberInfoVO;
import com.infect.vo.system.SatisfactionsurveyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
@Service
public class SatisfactionsurveyServiceImpl extends ServiceImpl<SatisfactionsurveyMapper, Satisfactionsurvey> implements ISatisfactionsurveyService {

    @Autowired
    private SatisfactionratingMapper satisfactionratingMapper;

    @Autowired
    private SatisfactionsurveyMapper satisfactionsurveyMapper;

    /**
     * 分页查询满意度调查列表（注意满意度计算）
     *
     * @param pageNo
     * @param pageNumber
     * @return
     */
    @Override
    public PageResult<SatisfactionsurveyVO> pageSelectSatisfactionSurvey(Integer pageNo, Integer pageNumber) {

        //创建分页条件
        Page<Satisfactionsurvey> page = Page.of(pageNo,pageNumber);
        page.addOrder(new OrderItem("CreateTime", false));

        //分页查询
        Page<Satisfactionsurvey> p = lambdaQuery().page(page);

        //封装VO结果
        PageResult<SatisfactionsurveyVO> pageResult = new PageResult<>();

        List<SatisfactionsurveyVO> list = new ArrayList<>();
        for (Satisfactionsurvey satisfactionsurvey:p.getRecords()){
            SatisfactionsurveyVO satisfactionsurveyVO = BeanUtil.copyProperties(satisfactionsurvey, SatisfactionsurveyVO.class);

            //插入满意度信息
            List<SatisfactionPairTemp> satisfactionPairTemps = satisfactionratingMapper.selectSatisfactionNumberAndTotalNumber(satisfactionsurveyVO.getSurveyID());
            if(satisfactionPairTemps!=null && !satisfactionPairTemps.isEmpty()) {
                satisfactionsurveyVO.setSatisfaction(getSatisfaction(satisfactionPairTemps));
            }

            list.add(satisfactionsurveyVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        return pageResult;
    }

    /**
     * 根据ID开放满意度调查(如果有其他正在开启中的调查，返回失败信息)
     *
     * @param surveyID
     * @return
     */
    @Override
    public boolean openSatisfaction(Integer surveyID) {
        //判断是否有其他正在开启中的调查
        Long count = lambdaQuery().eq(Satisfactionsurvey::getIsOpen, true).count();
        if (count!=0) {
            return false;
        }

        //开启
        Satisfactionsurvey satisfactionsurvey = new Satisfactionsurvey();
        satisfactionsurvey.setIsOpen(true);
        satisfactionsurvey.setSurveyID(surveyID);
        satisfactionsurveyMapper.updateById(satisfactionsurvey);
        return false;
    }

    /**
     * 统计满意度打分人数信息
     * @param surveyID
     * @return
     */
    @Override
    public SatisfactionNumberInfoVO getNumberInfo(Integer surveyID) {
        SatisfactionNumberInfoVO satisfactionNumberInfoVO = new SatisfactionNumberInfoVO();
        List<SatisfactionPairTemp> satisfactionPairTemps = satisfactionratingMapper.selectSatisfactionNumberAndTotalNumber(surveyID);
        for (SatisfactionPairTemp temp:satisfactionPairTemps) {
            if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.VERY_SATISFIED)){
                satisfactionNumberInfoVO.setVeryHappy(temp.getCount());
            }
            else if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.SATISFIED)){
                satisfactionNumberInfoVO.setHappy(temp.getCount());
            }
            else if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.NEUTRAL)){
                satisfactionNumberInfoVO.setNormal(temp.getCount());
            }
            else if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.DISSATISFIED)){
                satisfactionNumberInfoVO.setNoHappy(temp.getCount());
            }
            else if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.VERY_DISSATISFIED)){
                satisfactionNumberInfoVO.setVeryNoHappy(temp.getCount());
            }
        }
        satisfactionNumberInfoVO.setSatisfaction(getSatisfaction(satisfactionPairTemps));
        return satisfactionNumberInfoVO;
    }

    /**
     * 查询是否需要填写满意度打分信息(否：返回null，是：返回调查表信息)
     *
     * @param userID
     * @return
     */
    @Override
    public SatisfactionsurveyEmplyeeVO getIsNeedRating(Integer userID) {
        //获取开启的满意度调查
        Satisfactionsurvey satisfactionsurvey = lambdaQuery().eq(Satisfactionsurvey::getIsOpen, true).one();

        //若没有开启中的满意度调查，返回null
        if(satisfactionsurvey == null){
            return null;
        }

        //判断用户是否填写该调查
        Long number = satisfactionratingMapper.selectCount(
                new LambdaQueryWrapper<Satisfactionrating>()
                        .eq(Satisfactionrating::getSurveyID, satisfactionsurvey.getSurveyID())
                        .eq(Satisfactionrating::getUserID, userID)
        );
        if(number!=0) {
            return null;
        }

        //返回
        return BeanUtil.copyProperties(satisfactionsurvey, SatisfactionsurveyEmplyeeVO.class);
    }

    private Double getSatisfaction(List<SatisfactionPairTemp> map){
        int a = 0, b=0;
        for (SatisfactionPairTemp temp:map) {
            b+=temp.getCount();
            if(temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.SATISFIED)
            || temp.getSatisfactionLevel().equals(SatisfactionLevelEnumConstants.VERY_SATISFIED)) {
                a+=temp.getCount();
            }
        }
        return (double)a/(double)b;
    }
}
