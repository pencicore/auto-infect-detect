package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;
import com.infect.entity.*;
import com.infect.enums.DiagnosisResultsEnumConstants;
import com.infect.mapper.*;
import com.infect.properties.PathProperties;
import com.infect.service.MyDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DiagnosisServiceImpl implements MyDiagnosisService {

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

    @Autowired
    private DiagnosispersonalinfoMapper diagnosisPersonalInfoMapper;

    @Autowired
    private DiagnosisgeneralsymptomsMapper diagnosisGeneralSymptomsMapper;

    @Autowired
    private DiagnosisrespiratorysymptomsMapper diagnosisRespiratorySymptomsMapper;

    @Autowired
    private DiagnosisdigestivesymptomsMapper diagnosisDigestiveSymptomsMapper;

    @Autowired
    private DiagnosiscirculatorysymptomsMapper diagnosisCirculatorySymptomsMapper;

    @Autowired
    private DiagnosisneurologicalsymptomsMapper diagnosisNeurologicalSymptomsMapper;

    @Autowired
    private DiagnosislocalsymptomsMapper diagnosisLocalSymptomsMapper;

    @Autowired
    private DiagnosisothersymptomsMapper diagnosisOtherSymptomsMapper;

    @Autowired
    private DiagnosiscomplicationsMapper diagnosisComplicationsMapper;

    @Autowired
    private DiagnosisexaminationsMapper diagnosisexaminationsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PathProperties pathProperties;

    @Autowired
    private DiagnosisreportsMapper diagnosisreportsMapper;

    //将dto中诊断信息全部保存到
    @Override
    @Transactional
    public void saveDiagnosis(Integer userId, AllDiagnosisAndResultDTO allDiagnosisAndResultDTO) {
        //部分常量
        LocalDate nowTime = LocalDate.now();

        //1.保存诊断结果信息，并获取诊断结果id
        //1.1 从Dto中复制数据
        Diagnosisresults diagnosisresults = BeanUtil.copyProperties(allDiagnosisAndResultDTO.getDiagnosisResultsEmpDTO(), Diagnosisresults.class);
        //1.2 设置用户id，提交时间，提交用户id，提交用户类型
        diagnosisresults.setUserId(userId);
        diagnosisresults.setSubmissionUserType(DiagnosisResultsEnumConstants.SUBMISSION_USER_TYPE_RAILWAY_EMPLOYEE);
        diagnosisresults.setSubmissionUserId(userId);
        diagnosisresults.setSubmissionTime(nowTime);
        //1.3 查询数据库，通过用户id获取用户姓名
        String userName = userMapper.selectNameById(userId);
        //1.4 设置提交用户名
        diagnosisresults.setSubmissionUserName(userName);
        //1.5 将诊断结果信息保存到数据库中
        diagnosisresultsMapper.insert(diagnosisresults);
        //1.6 获取诊断结果信息id
        Integer diagnosisResultId = diagnosisresultsMapper.selectIdByUserIdAndTime(userId, nowTime);

        //2.保存各种诊断状况信息
        //2.1 保存个人基本信息表数据
        allDiagnosisAndResultDTO.getDiagnosispersonalinfo().setDiagnosisResultsId(diagnosisResultId);
        diagnosisPersonalInfoMapper.insert(allDiagnosisAndResultDTO.getDiagnosispersonalinfo());
        // 2.2 保存全身症状信息表数据
        Diagnosisgeneralsymptoms diagnosisGeneralSymptoms = allDiagnosisAndResultDTO.getDiagnosisgeneralsymptoms();
        diagnosisGeneralSymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisGeneralSymptomsMapper.insert(diagnosisGeneralSymptoms);
        // 2.3 保存呼吸系统症状信息表数据
        Diagnosisrespiratorysymptoms diagnosisRespiratorySymptoms = allDiagnosisAndResultDTO.getDiagnosisrespiratorysymptoms();
        diagnosisRespiratorySymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisRespiratorySymptomsMapper.insert(diagnosisRespiratorySymptoms);
        // 2.4 保存消化系统症状信息表数据
        Diagnosisdigestivesymptoms diagnosisDigestiveSymptoms = allDiagnosisAndResultDTO.getDiagnosisdigestivesymptoms();
        diagnosisDigestiveSymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisDigestiveSymptomsMapper.insert(diagnosisDigestiveSymptoms);
        // 2.5 保存循环系统症状信息表数据
        Diagnosiscirculatorysymptoms diagnosisCirculatorySymptoms = allDiagnosisAndResultDTO.getDiagnosiscirculatorysymptoms();
        diagnosisCirculatorySymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisCirculatorySymptomsMapper.insert(diagnosisCirculatorySymptoms);
        // 2.6 保存神经系统症状信息表数据
        Diagnosisneurologicalsymptoms diagnosisNeurologicalSymptoms = allDiagnosisAndResultDTO.getDiagnosisneurologicalsymptoms();
        diagnosisNeurologicalSymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisNeurologicalSymptomsMapper.insert(diagnosisNeurologicalSymptoms);
        // 2.7 保存局部症状信息表数据
        Diagnosislocalsymptoms diagnosisLocalSymptoms = allDiagnosisAndResultDTO.getDiagnosislocalsymptoms();
        diagnosisLocalSymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisLocalSymptomsMapper.insert(diagnosisLocalSymptoms);
        // 2.8 保存其他症状信息表数据
        Diagnosisothersymptoms diagnosisOtherSymptoms = allDiagnosisAndResultDTO.getDiagnosisothersymptoms();
        diagnosisOtherSymptoms.setDiagnosisResultsId(diagnosisResultId);
        diagnosisOtherSymptomsMapper.insert(diagnosisOtherSymptoms);
        // 2.9 保存并发症信息表数据
        Diagnosiscomplications diagnosisComplications = allDiagnosisAndResultDTO.getDiagnosiscomplications();
        diagnosisComplications.setDiagnosisResultsId(diagnosisResultId);
        diagnosisComplicationsMapper.insert(diagnosisComplications);

        //3.保存检查项目表信息
        Diagnosisexaminations diagnosisexaminations = allDiagnosisAndResultDTO.getDiagnosisexaminations();
        diagnosisexaminations.setDiagnosisResultsId(diagnosisResultId);
        diagnosisexaminationsMapper.insert(diagnosisexaminations);

        //4.保存文件到本地，并将文件目录保存至数据库
        if(allDiagnosisAndResultDTO.getFileIdList()==null){
            return;
        }
        for (Integer fileId : allDiagnosisAndResultDTO.getFileIdList()){
            diagnosisreportsMapper.updateDiagnosisResultIdByFileId(fileId,diagnosisResultId);
        }
    }

    @Override
    public Integer uploadReportFile(DiagnosisReportsDTO diagnosisReportsDTO) {

        MultipartFile file = diagnosisReportsDTO.getFile();

        // 跳过空文件
        if (file.isEmpty()) {
            return -1;
        }

        // 获取程序的当前工作目录
        String currentDir = System.getProperty("user.dir");

        // 定义保存文件的目录
        String saveDir = currentDir + File.separator + pathProperties.getDiagnosisFilePath();

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

        Diagnosisreports diagnosisreports = new Diagnosisreports();
        diagnosisreports.setReportType(diagnosisReportsDTO.getReportType());
        diagnosisreports.setFileType(fileType);
        diagnosisreports.setFileName(originalFileName);
        diagnosisreports.setFilePath(saveDir + File.separator + uniqueFileName);
        diagnosisreports.setUploadDate(LocalDateTime.now());
        // 保存报告文件信息
        diagnosisreportsMapper.insert(diagnosisreports);

        // 获取文件报告ID
        return diagnosisreportsMapper.selectIdByFilePath(saveDir + File.separator + uniqueFileName);
    }
}
