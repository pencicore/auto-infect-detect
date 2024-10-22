package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Pair;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;
import com.infect.dto.system.DiseaseStatisticsDTO;
import com.infect.entity.*;
import com.infect.entity.armorFusion.AllDiagnosis;
import com.infect.mapper.*;
import com.infect.properties.PathProperties;
import com.infect.service.MyDiagnosisService;
import com.infect.temporary.DiseaseStatisticsInfoTemp;
import com.infect.utils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Service
public class DiagnosisServiceImpl implements MyDiagnosisService {

    @Autowired
    private DiseasetypeMapper diseasetypeMapper;

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
    public void saveDiagnosis(Integer userId, Integer submissionUserId, AllDiagnosisAndResultDTO allDiagnosisAndResultDTO, String userType) {
        //部分常量
        LocalDate nowTime = LocalDate.now();

        //1.保存诊断结果信息，并获取诊断结果id
        //1.1 从Dto中复制数据
        Diagnosisresults diagnosisresults = BeanUtil.copyProperties(allDiagnosisAndResultDTO.getDiagnosisResultsEmpDTO(), Diagnosisresults.class);
        //1.2 设置用户id，提交时间，提交用户id，提交用户类型
        diagnosisresults.setUserId(userId);
        diagnosisresults.setSubmissionUserType(userType);
        diagnosisresults.setSubmissionUserId(submissionUserId);
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

        //创建报告文件实体类
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


    /**
     * 获取疾病类型列表
     *
     * @return
     */
    @Override
    public java.util.List<String> getDiseaseList() {
        return diseasetypeMapper.selectDiseaseTypeNameList();
    }

    /**
     * 根据时间，数据类型，疾病类型查询数据
     * @param diseaseStatisticsDTO
     * @return
     */
    @Override
    public Map<String, java.util.List<Pair<LocalDate, Integer>>> getDiseaseStatisticsListInfo(DiseaseStatisticsDTO diseaseStatisticsDTO) {
        Map<String, java.util.List<Pair<LocalDate, Integer>>> map = new HashMap<>();

        //查询数据库，获取每天每种疾病的患病人数
        List<DiseaseStatisticsInfoTemp> list = diagnosisresultsMapper.selectDiseaseStatisticsList(diseaseStatisticsDTO.getSourceType(),
                diseaseStatisticsDTO.getDiseaseList(),
                diseaseStatisticsDTO.getDateBegin(),
                diseaseStatisticsDTO.getDateEnd());

        //初始化map集合
        for (String s: diseaseStatisticsDTO.getDiseaseList()) {
            map.put(s,new ArrayList<>());
        }

        //封装VO数据
        for (DiseaseStatisticsInfoTemp temp: list) {
            map.get(temp.getDiseaseType()).add(new Pair<>(temp.getSubmissionTime(),temp.getCount()));
        }

        return map;
    }

    /**
     * 根据diagnosisResultsID获取所有诊断信息，还有文件id
     * @param diagnosisResultsID
     * @return
     */
    @Override
    public AllDiagnosis getAllDiagnosis(Integer diagnosisResultsID) {
        AllDiagnosis allDiagnosis = new AllDiagnosis();

        //查询诊断结果表
        allDiagnosis.setDiagnosisresults(
                diagnosisresultsMapper.selectById(diagnosisResultsID)
        );

        //查询9张诊断信息表
        allDiagnosis.setDiagnosispersonalinfo(
                diagnosisPersonalInfoMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosispersonalinfo>()
                                .eq(Diagnosispersonalinfo::getDiagnosisResultsId, diagnosisResultsID)
                )
        );

        allDiagnosis.setDiagnosisgeneralsymptoms(
                diagnosisGeneralSymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisgeneralsymptoms>()
                                .eq(Diagnosisgeneralsymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosisrespiratorysymptoms(
                diagnosisRespiratorySymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisrespiratorysymptoms>()
                                .eq(Diagnosisrespiratorysymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosisdigestivesymptoms(
                diagnosisDigestiveSymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisdigestivesymptoms>()
                                .eq(Diagnosisdigestivesymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosiscirculatorysymptoms(
                diagnosisCirculatorySymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosiscirculatorysymptoms>()
                                .eq(Diagnosiscirculatorysymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosisneurologicalsymptoms(
                diagnosisNeurologicalSymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisneurologicalsymptoms>()
                                .eq(Diagnosisneurologicalsymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosislocalsymptoms(
                diagnosisLocalSymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosislocalsymptoms>()
                                .eq(Diagnosislocalsymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosisothersymptoms(
                diagnosisOtherSymptomsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisothersymptoms>()
                                .eq(Diagnosisothersymptoms::getDiagnosisResultsId, diagnosisResultsID)
                )
        );
        allDiagnosis.setDiagnosiscomplications(
                diagnosisComplicationsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosiscomplications>()
                                .eq(Diagnosiscomplications::getDiagnosisResultsId, diagnosisResultsID)
                )
        );

        //查询检查项目表
        allDiagnosis.setDiagnosisexaminations(
                diagnosisexaminationsMapper.selectOne(
                        new LambdaQueryWrapper<Diagnosisexaminations>()
                                .eq(Diagnosisexaminations::getDiagnosisResultsId, diagnosisResultsID)
                )
        );

        //查询关联的文件id
        allDiagnosis.setFileIdList(
                diagnosisreportsMapper.selectIdsByDiagnosisResultsID(diagnosisResultsID)
        );

        //返回
        return allDiagnosis;
    }

    /**
     * 根据id更新诊断信息
     * @param allDiagnosis
     */
    @Override
    @Transactional
    public void updateDiagnosis(AllDiagnosis allDiagnosis) {
        //更新诊断结果表
        Diagnosisresults diagnosisresults = allDiagnosis.getDiagnosisresults();
        diagnosisresultsMapper.updateById(diagnosisresults);

        //更新9张诊断信息表
        Integer diagnosisResultsId = diagnosisresults.getDiagnosisResultsId();

        Diagnosispersonalinfo diagnosispersonalinfo = allDiagnosis.getDiagnosispersonalinfo();
        if(diagnosispersonalinfo!=null){
            int update = diagnosisPersonalInfoMapper.update(
                    diagnosispersonalinfo,
                    new LambdaQueryWrapper<Diagnosispersonalinfo>().eq(Diagnosispersonalinfo::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0) {
                diagnosispersonalinfo.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisPersonalInfoMapper.insert(allDiagnosis.getDiagnosispersonalinfo());
            }
        }

        Diagnosisgeneralsymptoms diagnosisgeneralsymptoms = allDiagnosis.getDiagnosisgeneralsymptoms();
        if(diagnosisgeneralsymptoms!=null){
            int update = diagnosisGeneralSymptomsMapper.update(
                    diagnosisgeneralsymptoms,
                    new LambdaQueryWrapper<Diagnosisgeneralsymptoms>().eq(Diagnosisgeneralsymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisgeneralsymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisGeneralSymptomsMapper.insert(diagnosisgeneralsymptoms);
            }
        }

        Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms = allDiagnosis.getDiagnosisrespiratorysymptoms();
        if(diagnosisrespiratorysymptoms!=null){
            int update = diagnosisRespiratorySymptomsMapper.update(
                    diagnosisrespiratorysymptoms,
                    new LambdaQueryWrapper<Diagnosisrespiratorysymptoms>().eq(Diagnosisrespiratorysymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisrespiratorysymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisRespiratorySymptomsMapper.insert(diagnosisrespiratorysymptoms);
            }
        }

        Diagnosisdigestivesymptoms diagnosisdigestivesymptoms = allDiagnosis.getDiagnosisdigestivesymptoms();
        if(diagnosisdigestivesymptoms!=null){
            int update = diagnosisDigestiveSymptomsMapper.update(
                    diagnosisdigestivesymptoms,
                    new LambdaQueryWrapper<Diagnosisdigestivesymptoms>().eq(Diagnosisdigestivesymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisdigestivesymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisDigestiveSymptomsMapper.insert(diagnosisdigestivesymptoms);
            }
        }

        Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms = allDiagnosis.getDiagnosiscirculatorysymptoms();
        if(diagnosiscirculatorysymptoms!=null){
            int update = diagnosisCirculatorySymptomsMapper.update(
                    diagnosiscirculatorysymptoms,
                    new LambdaQueryWrapper<Diagnosiscirculatorysymptoms>().eq(Diagnosiscirculatorysymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosiscirculatorysymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisCirculatorySymptomsMapper.insert(diagnosiscirculatorysymptoms);
            }
        }

        Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms = allDiagnosis.getDiagnosisneurologicalsymptoms();
        if(diagnosisneurologicalsymptoms!=null){
            int update = diagnosisNeurologicalSymptomsMapper.update(
                    diagnosisneurologicalsymptoms,
                    new LambdaQueryWrapper<Diagnosisneurologicalsymptoms>().eq(Diagnosisneurologicalsymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisneurologicalsymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisNeurologicalSymptomsMapper.insert(diagnosisneurologicalsymptoms);
            }
        }

        Diagnosislocalsymptoms diagnosislocalsymptoms = allDiagnosis.getDiagnosislocalsymptoms();
        if(diagnosislocalsymptoms!=null){
            int update = diagnosisLocalSymptomsMapper.update(
                    diagnosislocalsymptoms,
                    new LambdaQueryWrapper<Diagnosislocalsymptoms>().eq(Diagnosislocalsymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosislocalsymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisLocalSymptomsMapper.insert(diagnosislocalsymptoms);
            }
        }

        Diagnosisothersymptoms diagnosisothersymptoms = allDiagnosis.getDiagnosisothersymptoms();
        if(diagnosisothersymptoms!=null){
            int update = diagnosisOtherSymptomsMapper.update(
                    diagnosisothersymptoms,
                    new LambdaQueryWrapper<Diagnosisothersymptoms>().eq(Diagnosisothersymptoms::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisothersymptoms.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisOtherSymptomsMapper.insert(diagnosisothersymptoms);
            }
        }

        Diagnosiscomplications diagnosiscomplications = allDiagnosis.getDiagnosiscomplications();
        if(diagnosiscomplications!=null){
            int update = diagnosisComplicationsMapper.update(
                    diagnosiscomplications,
                    new LambdaQueryWrapper<Diagnosiscomplications>().eq(Diagnosiscomplications::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosiscomplications.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisComplicationsMapper.insert(diagnosiscomplications);
            }
        }

        //更新检查项目表
        Diagnosisexaminations diagnosisexaminations = allDiagnosis.getDiagnosisexaminations();
        if(diagnosisexaminations!=null){
            int update = diagnosisexaminationsMapper.update(
                    diagnosisexaminations,
                    new LambdaQueryWrapper<Diagnosisexaminations>().eq(Diagnosisexaminations::getDiagnosisResultsId, diagnosisResultsId)
            );
            if(update == 0){
                diagnosisexaminations.setDiagnosisResultsId(diagnosisResultsId);
                diagnosisexaminationsMapper.insert(diagnosisexaminations);
            }
        }

        //更新诊断文件
        if(allDiagnosis.getFileIdList()!=null){
            diagnosisreportsMapper.updateDiagnosisResultIdByDiagnosisResultId(0,diagnosisResultsId);

            List<Integer> fileIdList = allDiagnosis.getFileIdList();
            if(!fileIdList.isEmpty()){
                for (Integer fileId:fileIdList){
                    diagnosisreportsMapper.updateDiagnosisResultIdByFileId(fileId,diagnosisResultsId);
                }
            }
        }
    }

    /**
     * 导出文件：导出临床信息导出表
     * @param response
     */
    @Override
    public void getExcelClinicalInformationExportForm(HttpServletResponse response) {

        //获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "/infect-server/src/main/resources/templates/临床诊断信息导出表.xlsx";

        //查询打卡信息
        List<Diagnosisresults> diagnosisresultsList = diagnosisresultsMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        //生成二维数组
        for (Diagnosisresults obj:
                diagnosisresultsList) {
            List<Object> temp = new ArrayList<>();

            //添加诊断结果信息
            temp.add(obj);

            //添加用户信息
            temp.add(userMapper.selectById(obj.getUserId()));

            //获取诊断结果id
            Integer diagnosisResultsId=obj.getDiagnosisResultsId();

            //添加九张诊断信息表信息
            temp.add(diagnosisPersonalInfoMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosispersonalinfo>()
                            .eq(Diagnosispersonalinfo::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisGeneralSymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisgeneralsymptoms>()
                            .eq(Diagnosisgeneralsymptoms::getDiagnosisResultsId, diagnosisResultsId)
            ));
            temp.add(diagnosisRespiratorySymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisrespiratorysymptoms>()
                            .eq(Diagnosisrespiratorysymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisDigestiveSymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisdigestivesymptoms>()
                            .eq(Diagnosisdigestivesymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisCirculatorySymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosiscirculatorysymptoms>()
                            .eq(Diagnosiscirculatorysymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisNeurologicalSymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisneurologicalsymptoms>()
                            .eq(Diagnosisneurologicalsymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisLocalSymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosislocalsymptoms>()
                            .eq(Diagnosislocalsymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisOtherSymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisothersymptoms>()
                            .eq(Diagnosisothersymptoms::getDiagnosisResultsId,diagnosisResultsId)
            ));
            temp.add(diagnosisComplicationsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosiscomplications>()
                            .eq(Diagnosiscomplications::getDiagnosisResultsId,diagnosisResultsId)
            ));

            //添加检查诊断项目信息
            temp.add(diagnosisexaminationsMapper.selectOne(
                    new LambdaQueryWrapper<Diagnosisexaminations>()
                            .eq(Diagnosisexaminations::getDiagnosisResultsId,diagnosisResultsId)
            ));

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "临床诊断信息导出表.xlsx", fileName
                , 2, 1, 213
                , 2, 1
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
