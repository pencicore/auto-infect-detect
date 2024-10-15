package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.dto.system.UpdateBatchWeightScoringDTO;
import com.infect.entity.Diseasesubtype;
import com.infect.entity.Diseasetype;
import com.infect.entity.Symptomweighting;
import com.infect.mapper.DiseasesubtypeMapper;
import com.infect.mapper.DiseasetypeMapper;
import com.infect.mapper.SymptomweightingMapper;
import com.infect.service.ISymptomweightingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-26
 */
@Service
public class SymptomweightingServiceImpl extends ServiceImpl<SymptomweightingMapper, Symptomweighting> implements ISymptomweightingService {

    @Autowired
    private SymptomweightingMapper symptomweightingMapper;

    @Autowired
    private DiseasetypeMapper diseasetypeMapper;

    @Autowired
    private DiseasesubtypeMapper diseasesubtypeMapper;

    /**
     * 导入数据：将传染病初始权重打分表加工导入到数据库中
     * @param multipartFile
     */
    @Override
    @Transactional
    public void putValueDataByExcel(MultipartFile multipartFile) throws Exception {
        //清空权重表
        symptomweightingMapper.delete(null);

        //获取excel表sheet0和2页的数据
        List<List<String>> listData = ExcelUtil.readExcelFile(multipartFile, 0);
        List<List<String>> listName = ExcelUtil.readExcelFile(multipartFile, 2);

        for (Object t : listData) {
            System.out.println(t);
        }
        for (Object t : listName) {
            System.out.println(t);
        }

        List<Symptomweighting> symptomweightingList = new ArrayList<>();

        //二维遍历
        //第一维遍历疾病
        for (int i = 1; i <= 12; i++) {
            //获取疾病名
            String diseaseName = listData.get(i).get(1);

            //获取疾病id
            Integer diseaseId = diseasetypeMapper.selectIdByName(diseaseName);

            //第二维遍历字段
            for (int j = 3; j <= 117; j++) {
                //获取字段名
                String fieldName = listName.get(2).get(j);

                //获取对应表名
                String tableName = listName.get(1).get(j);

                //获取权重分数
                Integer weightScore = Integer.valueOf(listData.get(i).get(j));

                //第二次封装实体类
                Symptomweighting symptomweighting = new Symptomweighting();

                symptomweighting.setDiseaseTypeId(diseaseId);
                symptomweighting.setDiseaseTypeName(diseaseName);
                symptomweighting.setSymptomFieldName(fieldName);
                symptomweighting.setTableName(tableName);
                symptomweighting.setWeightScore(BigDecimal.valueOf(weightScore));

                //添加到symptomweighting列表中
                symptomweightingList.add(symptomweighting);
            }
        }

        //插入数据库
        this.saveBatch(symptomweightingList,100);

    }

    /**
     * 导出文件：传染病初始权重打分表加工
     * @param response
     */
    @Override
    public void getExcelInitialWeightScoringTableForInfectiousDiseases(HttpServletResponse response) {
        //设置 HTTP 响应头，指定文件名和 MIME 类型
        String fileNameUTF8;
        try {
            fileNameUTF8 = URLEncoder.encode("传染病初始权重打分表加工.xlsx", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameUTF8 + "\"");

        //获取模板文件输出流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("templates/传染病初始权重打分表加工.xlsx");

        try {
            // 根据模板创建一个新Excel文件
            XSSFWorkbook excel = new XSSFWorkbook(in);

            //获取新文件中第2页中症状名信息
            List<String> fieldNameList = new ArrayList<>();

            XSSFSheet sheet2 = excel.getSheetAt(2);
            for(int i=3;i<=117;i++){
                fieldNameList.add(
                        sheet2.getRow(2).getCell(i).getStringCellValue().trim()
                );
            }

            //获取疾病列表
            List<Diseasetype> diseasetypesList = diseasetypeMapper.selectList(null);
            int n = diseasetypesList.size();

            //遍历疾病
            for(int i=0;i<n;i++){
                int y=i+1; //y轴
                Diseasetype diseasetype = diseasetypesList.get(i);

                //根据疾病名，查询权重信息
                List<Symptomweighting> symptomweightingList = symptomweightingMapper.selectList(
                        new LambdaQueryWrapper<Symptomweighting>()
                                .eq(Symptomweighting::getDiseaseTypeId, diseasetype.getDiseaseTypeId())
                );

                //将编号，疾病信息，疾病子信息插入到excel表中
                XSSFSheet sheet0 = excel.getSheetAt(0);
                sheet0.createRow(y);
                Row row = sheet0.getRow(y);

                row.createCell(0).setCellValue(y);
                row.createCell(1).setCellValue(diseasetype.getDiseaseTypeName());

                if(diseasetype.getHasSubtype()){
                    List<Diseasesubtype> diseasesubtypes = diseasesubtypeMapper.selectList(
                            new LambdaQueryWrapper<Diseasesubtype>()
                                    .eq(Diseasesubtype::getDiseaseTypeId, diseasetype.getDiseaseTypeId())
                    );
                    StringBuilder value = null;
                    for (Diseasesubtype diseasesubtype: diseasesubtypes) {
                        if(value==null){
                            value = new StringBuilder(diseasesubtype.getSubtypeName());
                        }
                        else {
                            value.append(",").append(diseasesubtype.getSubtypeName());
                        }
                    }
                    row.createCell(2).setCellValue(value.toString());
                }

                //将症状名和权重信息封装到map中，节省时间，（这就是算法的力量）
                Map<String, BigDecimal> map = new HashMap<>();
                for (Symptomweighting symptomweighting:symptomweightingList) {
                    map.put(symptomweighting.getSymptomFieldName(),symptomweighting.getWeightScore());
                }
                
                //插入权重信息到excel表
                for (int j = 0; j <= 114; j++) {
                    int x = j+3;
                    row.createCell(x).setCellValue(
                            String.valueOf(map.get(fieldNameList.get(j)))
                    );
                }

            }

            //通过输出流将Excel文件下载到客户端中
            ServletOutputStream out=response.getOutputStream();
            excel.write(out);

            //关闭资源
            in.close();
            excel.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 根据疾病id批量更新疾病权重信息
     *
     * @param updateDTOList
     * @return
     */
    @Override
    public boolean updateBatchWeightScoring(List<UpdateBatchWeightScoringDTO> updateDTOList) {
        //查询原来的这些字段的总分数
        BigDecimal sumOld = symptomweightingMapper.selectCountByUpdateDTOList(updateDTOList);

        //将更新后的总分数相加
        BigDecimal sumNew = BigDecimal.valueOf(0);
        for(UpdateBatchWeightScoringDTO dto:updateDTOList){
           sumNew = sumNew.add(dto.getWeightScore());
        }

        //如果更新前和更新后的分数不同，则返回false
        if(sumOld != sumNew) {
            return false;
        }

        //相同则进行批量更新
        List<Symptomweighting> list = BeanUtil.copyToList(updateDTOList,Symptomweighting.class);
        this.updateBatchById(list,50);
        return true;
    }
}
