package com.infect.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.HospitalPageDTO;
import com.infect.entity.*;
import com.infect.mapper.HospitalMapper;
import com.infect.result.PageResult;
import com.infect.service.IHospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-27
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements IHospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;

    /**
     * 导入数据：将医院基础信息导出表信息导入到数据库中
     * @param file
     */
    @Override
    @Transactional
    public void putHospitalDataByExcel(MultipartFile file) throws Exception {
        //获取excel表sheet0数据
        List<List<String>> lists = ExcelUtil.readExcelFile(file, 0);

        //遍历数据，封装实体类列表
        int n = lists.size();
        List<Hospital> hospitalList = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            List<String> list = lists.get(i);
            if(list.size()<4) break;

            String hospitalName = list.get(1);
            String hospitalPhoneNumber = list.get(2);
            String address = list.get(3);

            Hospital hospital = new Hospital();
            hospital.setHospitalName(hospitalName);
            hospital.setHospitalPhoneNumber(hospitalPhoneNumber);
            hospital.setAddress(address);

            if(hospitalName.isEmpty() || hospitalPhoneNumber.isEmpty() || address.isEmpty()){
                continue;
            }

            hospitalList.add(hospital);
        }

        //插入数据库
        this.saveBatch(hospitalList, 20);
    }

    /**
     * 导出文件：导出医院基础信息导出表
     * @param response
     */
    @Override
    public void getExcelHospitalBasicInformationImportForm(HttpServletResponse response) {

        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "\\infect-server\\src\\main\\resources\\templates\\医院基础信息导入表.xlsx";

        List<List<Object>> listList = new ArrayList<>();
        List<Hospital> hospitalList = hospitalMapper.selectList(null);

        for (Object obj:hospitalList) {
            List<Object> temp = new ArrayList<>();
            temp.add(obj);
            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "医院基础信息导出表.xlsx", filePath
                , 1,1,52
                ,1,1
                ,listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageResult<Hospital> pageSelectHospitalInfo(HospitalPageDTO hospitalPageDTO) {
        String hospitalName = hospitalPageDTO.getHospitalName();

        //构建分页条件
        Page<Hospital> page = Page.of(hospitalPageDTO.getPageNo(), hospitalPageDTO.getPageSize());

        //分页查询
        Page<Hospital> p = lambdaQuery()
                .like(hospitalName!=null, Hospital::getHospitalName, hospitalName)
                .page(page);

        //封装返回结果
        PageResult<Hospital> pageResult = new PageResult();
        pageResult.setTotal(p.getTotal());
        pageResult.setRecords(p.getRecords());

        //返回
        return pageResult;
    }


}
