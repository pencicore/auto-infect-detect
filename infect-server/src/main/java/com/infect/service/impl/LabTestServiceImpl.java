package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.entity.Labtestfiles;
import com.infect.entity.Labtestreport;
import com.infect.mapper.LabtestfilesMapper;
import com.infect.mapper.LabtestreportMapper;
import com.infect.properties.PathProperties;
import com.infect.service.MyLabTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class LabTestServiceImpl implements MyLabTestService {

    @Autowired
    private PathProperties pathProperties;

    @Autowired
    private LabtestfilesMapper labtestfilesMapper;

    @Autowired
    private LabtestreportMapper labtestreportMapper;

    @Override
    public Integer uploadLabTestFile(LabTestFileDTO labTestFileDTO) {

        MultipartFile file = labTestFileDTO.getFile();

        // 跳过空文件
        if (file.isEmpty()) {
            return -1;
        }

        // 获取程序的当前工作目录
        //TODO 后期这里可以优化一下
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
        String fileExtension = originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf('.')) : "";
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

        // 创建报告文件实体类
        Labtestfiles labtestfiles = Labtestfiles.builder()
                .labTestReportId(-1)
                .specimenType(labTestFileDTO.getLabTestType())
                .fileType(fileType)
                .fileName(originalFileName)
                .filePath(saveDir + File.separator + uniqueFileName)
                .build();

        // 保存报告文件信息
        labtestfilesMapper.insert(labtestfiles);

        // 获取文件报告ID
        return labtestfilesMapper.selectIdByFilePath(saveDir + File.separator + uniqueFileName);

    }

    @Override
    public void saveLabTest(LabTestReportDTO labTestReportDTO, Integer userId) {
        //创建LabTestReport实体类
        Labtestreport labtestreport = BeanUtil.copyProperties(labTestReportDTO, Labtestreport.class);
        labtestreport.setUserId(userId);
        labtestreport.setUploadDate(LocalDate.now());

        //插入数据
        labtestreportMapper.insert(labtestreport);

        //查询数据，获取id字段
        Integer labTestReportId = labtestreportMapper.selectLabTestReportIdByUserIdAndDate(userId,LocalDate.now());

        //变量文件id数组，修改文件字段中的实验室检测报告id
        for (Integer fileId : labTestReportDTO.getLabTestFileIds()) {
            labtestfilesMapper.updateLabTestReportIdByFileId(fileId,labTestReportId);
        }
    }
}
