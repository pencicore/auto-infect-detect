package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.DiseaseTypePageDTO;
import com.infect.entity.*;
import com.infect.mapper.DiseasesubtypeMapper;
import com.infect.mapper.DiseasetypeMapper;
import com.infect.result.PageResult;
import com.infect.service.IDiseasetypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.vo.system.DiseaseTypePageVO;
import com.infect.vo.system.UserFeedBackPageVO;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-25
 */
@Service
public class DiseasetypeServiceImpl extends ServiceImpl<DiseasetypeMapper, Diseasetype> implements IDiseasetypeService {

    @Autowired
    private DiseasesubtypeMapper diseasesubtypeMapper;

    @Autowired
    private DiseasetypeMapper diseasetypeMapper;

    /**
     * 分页查询疾病基础信息
     * @param diseaseTypePageDTO
     * @return
     */
    @Override
    public PageResult<DiseaseTypePageVO> pageSelectDiseaseType(DiseaseTypePageDTO diseaseTypePageDTO) {
        String text = diseaseTypePageDTO.getText();

        //构造分页条件
        Page<Diseasetype> page = Page.of(diseaseTypePageDTO.getPageNo(),diseaseTypePageDTO.getPageSize());

        //分页查询
        Page<Diseasetype> p = lambdaQuery()
                .like(text!=null, Diseasetype::getDiseaseTypeName, text)
                .page(page);

        //封装VO结果
        PageResult<DiseaseTypePageVO> pageResult = new PageResult<>();

        List<DiseaseTypePageVO> list = new ArrayList<>();
        for(Diseasetype diseasetype:p.getRecords()){
            DiseaseTypePageVO diseaseTypePageVO = BeanUtil.copyProperties(diseasetype, DiseaseTypePageVO.class);

            //如果该疾病有子疾病，则查询数据库
            if(diseaseTypePageVO.getHasSubtype()){
                diseaseTypePageVO.setSubDiseaseList(
                        diseasesubtypeMapper.selectList(
                                new LambdaQueryWrapper<Diseasesubtype>()
                                        .eq(Diseasesubtype::getDiseaseTypeId, diseaseTypePageVO.getDiseaseTypeId())
                        )
                );
            }

            list.add(diseaseTypePageVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }

    /**
     * 导出文件：导出疾病基础数据导出表
     * @param response
     */
    @Override
    public void getExcelDiseaseBasicDataExportTable(HttpServletResponse response) {
        // 对文件名进行 URL 编码，确保中文字符在浏览器中正确显示
        String fileName = null;
        try {
            fileName = URLEncoder.encode("疾病基础数据导出表.xlsx", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        //1. 查询数据库，获取用户信息
        List<Diseasetype> list = diseasetypeMapper.selectList(null);

        //2.通过POI将数据写入到EXcel文件中
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("templates/疾病基础数据导出表.xlsx");

        try {
            //根据模板创建一个新的Excel文件
            XSSFWorkbook excel = new XSSFWorkbook(in);
            XSSFSheet sheet = excel.getSheetAt(0);

            //填充数据
            XSSFRow row;
            Diseasetype diseasetype;
            int n=list.size();

            for (int i = 0; i < n; i++) {
                row = sheet.getRow(i + 1);
                // 当前行为空，需要先创建该行
                if (row == null) {
                    row = sheet.createRow(i + 1);
                }

                diseasetype = list.get(i);

                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(diseasetype.getDiseaseTypeName());
                row.createCell(2).setCellValue(
                        diseasetype.getHasSubtype()?"是":"否"
                );
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
                    row.createCell(3).setCellValue(value.toString());
                }
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
