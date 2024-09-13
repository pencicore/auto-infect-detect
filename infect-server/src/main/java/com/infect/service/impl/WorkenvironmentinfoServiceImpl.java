package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.EnvironmentPageDTO;
import com.infect.entity.User;
import com.infect.entity.Workenvironmentinfo;
import com.infect.mapper.UserMapper;
import com.infect.mapper.WorkenvironmentinfoMapper;
import com.infect.result.PageResult;
import com.infect.service.IWorkenvironmentinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.vo.system.EnvironmentInfoVO;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

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
        if (workenvironmentinfo.getWorkStationAltitude() == null || workenvironmentinfo.getWorkStationAltitude() <= 0){
            workenvironmentinfo.setWorkStationAltitude(1500);
        }
        if (workenvironmentinfo.getWorkStationName() == null || workenvironmentinfo.getWorkStationName().equals("")){
            workenvironmentinfo.setWorkStationName("无");
        }
        if (workenvironmentinfo.getWindowOpenArea() == null){
            workenvironmentinfo.setWindowOpenArea(BigDecimal.valueOf(12.75));
        }
        if (workenvironmentinfo.getVentilationCondition()== null){
            workenvironmentinfo.setVentilationCondition("不开窗通风");
        }
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

    @Override
    public void updateWorkEnvironmentInfo(Workenvironmentinfo workenvironmentinfo) {
        workenvironmentinfoMapper.updateWorkEnvironment(workenvironmentinfo);
    }

    @Override
    public Workenvironmentinfo getEnvironmentInfo(Integer currentId, String date) {

        // 创建查询条件
        QueryWrapper<Workenvironmentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", currentId)
                .eq("YearMonth", date);

        // 执行查询
        Workenvironmentinfo results = workenvironmentinfoMapper.selectOne(queryWrapper);
        if (results == null){
            return null;
        }
        return results;
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

    /**
     * 根据地点名和时间分页查询用户填写得每月工作环境
     * @param environmentPageDTO
     * @return
     */
    @Override
    public PageResult<EnvironmentInfoVO> pageSelectWorkEnvironment(EnvironmentPageDTO environmentPageDTO) {
        String workStationName = environmentPageDTO.getWorkStationName();
        String beginYearMonth = environmentPageDTO.getBeginYearMonth();
        String endYearMonth = environmentPageDTO.getEndYearMonth();

        Boolean haveTimeLimit = beginYearMonth!=null && endYearMonth!=null && beginYearMonth.isEmpty() && endYearMonth.isEmpty();

        //构建分页条件
        Page<Workenvironmentinfo> page = Page.of(environmentPageDTO.getPageNo(), environmentPageDTO.getPageSize());

        //分页查询
        Page<Workenvironmentinfo> p = lambdaQuery()
                .like(workStationName!=null && !workStationName.isEmpty(), Workenvironmentinfo::getWorkStationName, workStationName)
                .gt(haveTimeLimit, Workenvironmentinfo::getYearMonth,beginYearMonth)
                .lt(haveTimeLimit, Workenvironmentinfo::getYearMonth,endYearMonth)
                .page(page);

        //封装VO结果
        PageResult<EnvironmentInfoVO> pageResult = new PageResult<>();
        pageResult.setTotal(p.getTotal());

        List<EnvironmentInfoVO> list = new ArrayList<>();
        for(Workenvironmentinfo t:p.getRecords()){
            String name = userMapper.selectNameById(t.getUserId());

            EnvironmentInfoVO environmentInfoVO = BeanUtil.copyProperties(t, EnvironmentInfoVO.class);
            environmentInfoVO.setName(name);

            list.add(environmentInfoVO);
        }
        pageResult.setRecords(list);

        //返回
        return pageResult;
    }

    /**
     * 导出工作环境基本信息表
     * @param response
     */
    @Override
    public void queryAllWorkEnvironmentInfoToExcel(HttpServletResponse response) {
        // 对文件名进行 URL 编码，确保中文字符在浏览器中正确显示
        String fileName = null;
        try {
            fileName = URLEncoder.encode("工作环境基本信息导出表.xlsx", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        //1. 查询数据库，获取用户信息
        List<Workenvironmentinfo> list = workenvironmentinfoMapper.selectList(null);

        List<User> userList = new ArrayList<>();
        int n=list.size();
        for (int i = 0; i < n; i++) {
            userList.add(userMapper.selectById(list.get(i).getUserId()));
        }

        //2.通过POI将数据写入到EXcel文件中
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("templates/工作环境基本信息导出表.xlsx");

        try {
            //根据模板创建一个新的Excel文件
            XSSFWorkbook excel = new XSSFWorkbook(in);
            XSSFSheet sheet = excel.getSheet("工作环境基本信息导出表");

            //填充数据
            XSSFRow row;
            Workenvironmentinfo workenvironmentinfo;
            User user;
            for (int i = 0; i < n; i++) {
                row = sheet.getRow(i + 2);
                // 当前行为空，需要先创建该行
                if (row == null) {
                    row = sheet.createRow(i + 1);
                }

                workenvironmentinfo = list.get(i);
                user = userList.get(i);

                for (int j = 0; j < 36; j++) {
                    if (row == null) {
                        row = sheet.createRow(j);
                    }
                }

                // 序号
                row.createCell(0).setCellValue(i + 1);

                // 姓名
                row.createCell(1).setCellValue(user.getName() != null ? user.getName() : "");

                // 性别
                row.createCell(2).setCellValue(user.getGender() != null ? user.getGender() : "");

                // 年龄
                row.createCell(3).setCellValue(user.getAge() != null ? user.getAge().toString() : "");

                // 民族
                row.createCell(4).setCellValue(user.getEthnicity() != null ? user.getEthnicity() : "");

                // 部门
                row.createCell(5).setCellValue(user.getDepartment() != null ? user.getDepartment() : "");

                // 电话号码
                row.createCell(6).setCellValue(user.getPhoneNumber() != null ? user.getPhoneNumber() : "");

                // 其他字段（同样做非空判断）
                row.createCell(7).setCellValue(workenvironmentinfo.getYearMonth() != null ? workenvironmentinfo.getYearMonth() : "");
                row.createCell(8).setCellValue(workenvironmentinfo.getSubmissionTime() != null ? workenvironmentinfo.getSubmissionTime().toString() : "");
                row.createCell(9).setCellValue(workenvironmentinfo.getWorkStationAltitude() != null ? workenvironmentinfo.getWorkStationAltitude().toString() : "");
                row.createCell(10).setCellValue(workenvironmentinfo.getWorkStationName() != null ? workenvironmentinfo.getWorkStationName() : "");
                row.createCell(11).setCellValue(workenvironmentinfo.getDormitoryBuildingNumber() != null ? workenvironmentinfo.getDormitoryBuildingNumber().toString() : "");
                row.createCell(12).setCellValue(workenvironmentinfo.getDormitoryRoomNumber() != null ? workenvironmentinfo.getDormitoryRoomNumber().toString() : "");
                row.createCell(13).setCellValue(workenvironmentinfo.getDormitoryOccupants() != null ? workenvironmentinfo.getDormitoryOccupants().toString() : "");
                row.createCell(14).setCellValue(workenvironmentinfo.getDormitoryArea() != null ? workenvironmentinfo.getDormitoryArea().toString() : "");
                row.createCell(15).setCellValue(workenvironmentinfo.getWindowOpenArea() != null ? workenvironmentinfo.getWindowOpenArea().toString() : "");
                row.createCell(16).setCellValue(workenvironmentinfo.getVentilationCondition() != null ? workenvironmentinfo.getVentilationCondition() : "");
                row.createCell(17).setCellValue(workenvironmentinfo.getAvgWorkRoomPeople() != null ? workenvironmentinfo.getAvgWorkRoomPeople().toString() : "");
                row.createCell(18).setCellValue(workenvironmentinfo.getAvgWorkFaceToFace() != null ? workenvironmentinfo.getAvgWorkFaceToFace().toString() : "");
                row.createCell(19).setCellValue(workenvironmentinfo.getAvgWorkPhysicalContact() != null ? workenvironmentinfo.getAvgWorkPhysicalContact().toString() : "");
                row.createCell(20).setCellValue(workenvironmentinfo.getAvgBreakfastRoomPeople() != null ? workenvironmentinfo.getAvgBreakfastRoomPeople().toString() : "");
                row.createCell(21).setCellValue(workenvironmentinfo.getAvgBreakfastFaceToFace() != null ? workenvironmentinfo.getAvgBreakfastFaceToFace().toString() : "");
                row.createCell(22).setCellValue(workenvironmentinfo.getAvgBreakfastPhysicalContact() != null ? workenvironmentinfo.getAvgBreakfastPhysicalContact().toString() : "");
                row.createCell(23).setCellValue(workenvironmentinfo.getAvgLunchRoomPeople() != null ? workenvironmentinfo.getAvgLunchRoomPeople().toString() : "");
                row.createCell(24).setCellValue(workenvironmentinfo.getAvgLunchFaceToFace() != null ? workenvironmentinfo.getAvgLunchFaceToFace().toString() : "");
                row.createCell(25).setCellValue(workenvironmentinfo.getAvgLunchPhysicalContact() != null ? workenvironmentinfo.getAvgLunchPhysicalContact().toString() : "");
                row.createCell(26).setCellValue(workenvironmentinfo.getAvgDinnerRoomPeople() != null ? workenvironmentinfo.getAvgDinnerRoomPeople().toString() : "");
                row.createCell(27).setCellValue(workenvironmentinfo.getAvgDinnerFaceToFace() != null ? workenvironmentinfo.getAvgDinnerFaceToFace().toString() : "");
                row.createCell(28).setCellValue(workenvironmentinfo.getAvgDinnerPhysicalContact() != null ? workenvironmentinfo.getAvgDinnerPhysicalContact().toString() : "");
                row.createCell(29).setCellValue(workenvironmentinfo.getCollectiveActivitiesCount() != null ? workenvironmentinfo.getCollectiveActivitiesCount().toString() : "");
                row.createCell(30).setCellValue(workenvironmentinfo.getAvgActivityRoomPeople() != null ? workenvironmentinfo.getAvgActivityRoomPeople().toString() : "");
                row.createCell(31).setCellValue(workenvironmentinfo.getAvgActivityFaceToFace() != null ? workenvironmentinfo.getAvgActivityFaceToFace().toString() : "");
                row.createCell(32).setCellValue(workenvironmentinfo.getAvgActivityPhysicalContact() != null ? workenvironmentinfo.getAvgActivityPhysicalContact().toString() : "");
                row.createCell(33).setCellValue(workenvironmentinfo.getAvgMonthlyPressure() != null ? workenvironmentinfo.getAvgMonthlyPressure().toString() : "");
                row.createCell(34).setCellValue(workenvironmentinfo.getMaxTemperature() != null ? workenvironmentinfo.getMaxTemperature().toString() : "");
                row.createCell(35).setCellValue(workenvironmentinfo.getMinTemperature() != null ? workenvironmentinfo.getMinTemperature().toString() : "");
            }


            //3.通过输出流将Excel文件下载到客户端中
            ServletOutputStream out=response.getOutputStream();
            excel.write(out);

            //4.关闭资源
            in.close();
            out.close();
            excel.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
