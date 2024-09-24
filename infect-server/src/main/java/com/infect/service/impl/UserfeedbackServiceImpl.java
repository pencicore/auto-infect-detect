package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.dto.system.UserFeedBackPageDTO;
import com.infect.entity.Diagnosisresults;
import com.infect.entity.Labtestreport;
import com.infect.entity.User;
import com.infect.entity.Userfeedback;
import com.infect.mapper.UserMapper;
import com.infect.mapper.UserfeedbackMapper;
import com.infect.result.PageResult;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IUserfeedbackService;
import com.infect.utils.ExcelUtil;
import com.infect.vo.system.DiagnosisPageVO;
import com.infect.vo.system.UserFeedBackPageVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserfeedbackServiceImpl extends ServiceImpl<UserfeedbackMapper, Userfeedback> implements IUserfeedbackService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserfeedbackMapper userfeedbackMapper;

    /**
     * 根据用户名，联系电话，标题分页查询用户反馈信息
     * @param userFeedBackPageDTO
     * @return
     */
    @Override
    public PageResult<UserFeedBackPageVO> pageSelectFeedBack(UserFeedBackPageDTO userFeedBackPageDTO) {
        String name = userFeedBackPageDTO.getName();
        String phoneNumber = userFeedBackPageDTO.getPhoneNumber();
        String feedbackTitle = userFeedBackPageDTO.getFeedbackTitle();

        //构造分页条件
        Page<Userfeedback> page = Page.of(userFeedBackPageDTO.getPageNo(),userFeedBackPageDTO.getPageSize());
        page.addOrder(new OrderItem("FeedbackDate",false));

        //分页查询
        Page<Userfeedback> p = lambdaQuery()
                .like(name!=null, Userfeedback::getName, name)
                .like(phoneNumber!=null, Userfeedback::getPhoneNumber, phoneNumber)
                .like(feedbackTitle!=null, Userfeedback::getFeedbackTitle, feedbackTitle)
                .page(page);

        //封装VO结果
        PageResult<UserFeedBackPageVO> pageResult = new PageResult<>();

        List<UserFeedBackPageVO> list = new ArrayList<>();
        for(Userfeedback userfeedback:p.getRecords()){
            UserFeedBackPageVO userFeedBackPageVO = new UserFeedBackPageVO();

            //对文本内容进行处理
            if(userfeedback.getFeedbackText().length()>20){
                userfeedback.setFeedbackText(
                        userfeedback.getFeedbackText().substring(0,18)+"...."
                );
            }
            if(userfeedback.getFeedbackTitle().length()>20){
                userfeedback.setFeedbackTitle(
                        userfeedback.getFeedbackTitle().substring(0,18)+"...."
                );
            }

            BeanUtil.copyProperties(userfeedback, userFeedBackPageVO);
            list.add(userFeedBackPageVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }


    /**
     * 导出文件：导出用户反馈信息导出表
     * @param response
     */
    @Override
    public void getExcelUserFeedbackInformationExportTable(HttpServletResponse response) {
        //获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "\\infect-server\\src\\main\\resources\\templates\\用户反馈信息导出表.xlsx";

        //查询用户反馈信息
        List<Userfeedback> userfeedbackList = userfeedbackMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        //生成二维数组
        for (Userfeedback obj:
                userfeedbackList) {
            List<Object> temp = new ArrayList<>();

            //添加用户反馈信息
            temp.add(obj);

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "用户反馈信息导出表.xlsx", fileName
                , 1, 1, 5
                , 1, 1
                , listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
