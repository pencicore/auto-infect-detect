package com.infect.service;

import com.infect.dto.system.HospitalPageDTO;
import com.infect.entity.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-09-27
 */
public interface IHospitalService extends IService<Hospital> {

    void putHospitalDataByExcel(MultipartFile file) throws Exception;

    void getExcelHospitalBasicInformationImportForm(HttpServletResponse response);

    PageResult<Hospital> pageSelectHospitalInfo(HospitalPageDTO hospitalPageDTO);
}
