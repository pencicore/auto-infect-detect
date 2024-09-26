package com.infect.service;

import com.infect.dto.system.DiseaseTypePageDTO;
import com.infect.entity.Diseasetype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.system.DiseaseTypePageVO;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-25
 */
public interface IDiseasetypeService extends IService<Diseasetype> {

    PageResult<DiseaseTypePageVO> pageSelectDiseaseType(DiseaseTypePageDTO diseaseTypePageDTO);

    void getExcelDiseaseBasicDataExportTable(HttpServletResponse response);
}
