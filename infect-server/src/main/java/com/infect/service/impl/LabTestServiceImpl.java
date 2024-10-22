package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.entity.*;
import com.infect.mapper.LabtestfilesMapper;
import com.infect.mapper.LabtestreportMapper;
import com.infect.mapper.UserMapper;
import com.infect.properties.PathProperties;
import com.infect.result.Result;
import com.infect.service.MyLabTestService;
import com.infect.utils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LabTestServiceImpl implements MyLabTestService {

    @Autowired
    private PathProperties pathProperties;

    @Autowired
    private LabtestfilesMapper labtestfilesMapper;

    @Autowired
    private LabtestreportMapper labtestreportMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer uploadLabTestFile(LabTestFileDTO labTestFileDTO) {

        MultipartFile file = labTestFileDTO.getFile();
        // 跳过空文件
        if (file.isEmpty()) {
            return -1;
        }
        // 获取程序的当前工作目录
        // TODO 后期这里可以优化一下
        String currentDir = System.getProperty("user.dir");
        // 定义保存文件的目录
        String saveDir = currentDir + File.separator + pathProperties.getLabTestFilePath();

        // 创建保存目录
        File directory = new File(saveDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目录
        }
        // 为文件名添加UUID前缀
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf('.'))
                : "";
        String uniqueFileName = UUID.randomUUID() + fileExtension;

        // 将文件保存到指定目录
        File destinationFile = new File(directory, uniqueFileName);
        try {
            file.transferTo(destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }

        // 获取文件后缀
        int index = originalFileName.lastIndexOf('.');
        if (index == -1) {
            throw new RuntimeException("File type extraction failed");
        }
        String fileType = originalFileName.substring(index + 1);
        Labtestfiles labtestfiles = new Labtestfiles();
        labtestfiles.setSpecimenType(labTestFileDTO.getLabTestType());
        labtestfiles.setFileName(originalFileName);
        labtestfiles.setFilePath(saveDir + File.separator + uniqueFileName);
        labtestfiles.setFileType(fileType);
        labtestfiles.setLabTestReportId(-1);
        // 保存报告文件信息
        labtestfilesMapper.insert(labtestfiles);

        // 获取文件报告ID
        return labtestfilesMapper.selectIdByFilePath(saveDir + File.separator + uniqueFileName);

    }

    @Override
    public Result saveLabTest(LabTestReportDTO labTestReportDTO, Integer userId) {
        // // 查询数据，获取 id 字段
        // List<Integer> labTestReportIds =
        // labtestreportMapper.selectLabTestReportIdByUserIdAndDate(userId,
        // LocalDate.now());
        //
        // if (labTestReportIds.isEmpty()) {
        // // 处理没有找到的情况
        // return Result.error("未找到相关数据");
        // } else if (labTestReportIds.size() > 1) {
        // return Result.error("您今日已经提交过了");
        // } else {
        // // 创建 LabTestReport 实体类
        // Labtestreport labtestreport = BeanUtil.copyProperties(labTestReportDTO,
        // Labtestreport.class);
        // labtestreport.setUserId(userId);
        // labtestreport.setUploadDate(LocalDate.now());
        //
        // // 插入数据
        // labtestreportMapper.insert(labtestreport);
        // // 只有一个结果
        // Integer labTestReportId = labTestReportIds.get(0);
        // // 变量文件 id 数组，修改文件字段中的实验室检测报告 id
        // for (Integer fileId : labTestReportDTO.getLabTestFileIds()) {
        // labtestfilesMapper.updateLabTestReportIdByFileId(fileId, labTestReportId);
        // }
        // return Result.success();
        // }
        List<Integer> labTestReportIds = labtestreportMapper.selectLabTestReportIdByUserIdAndDate(userId,
                LocalDate.now());

        if (labTestReportIds.size() != 0) {
            return Result.error("您今日已经提交过了");
        } else {
            // 创建 LabTestReport 实体类
            Labtestreport labtestreport = BeanUtil.copyProperties(labTestReportDTO, Labtestreport.class);
            labtestreport.setUserId(userId);
            labtestreport.setUploadDate(LocalDate.now());

            // 插入数据
            labtestreportMapper.insert(labtestreport);
            // 只有一个结果
            labTestReportIds = labtestreportMapper.selectLabTestReportIdByUserIdAndDate(userId, LocalDate.now());
            Integer labTestReportId = labTestReportIds.get(0);
            // 变量文件 id 数组，修改文件字段中的实验室检测报告 id
            for (Integer fileId : labTestReportDTO.getLabTestFileIds()) {
                labtestfilesMapper.updateLabTestReportIdByFileId(fileId, labTestReportId);
            }
            return Result.success();
        }
    }

    /**
     * 导出文件：导出检测信息导出表
     * 
     * @param response
     */
    @Override
    public void getDetectionInformationExportFormExcel(HttpServletResponse response) {
        // 获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "/infect-server/src/main/resources/templates/检测信息导出表.xlsx";

        // 查询实验室检测信息
        List<Labtestreport> labtestreportList = labtestreportMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        // 生成二维数组
        for (Labtestreport obj : labtestreportList) {
            List<Object> temp = new ArrayList<>();

            // 添加实验室检测信息
            temp.add(obj);

            // 添加用户信息
            temp.add(userMapper.selectById(obj.getUserId()));

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "检测信息导出表.xlsx", fileName, 2, 1, 213, 2, 1, listList);

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
