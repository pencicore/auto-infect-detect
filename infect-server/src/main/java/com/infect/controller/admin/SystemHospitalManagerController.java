package com.infect.controller.admin;

import com.infect.dto.system.HospitalPageDTO;
import com.infect.entity.Hospital;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IHospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Api(tags = "系统管理-医院基础数据管理")
@RestController
@RequestMapping("/admin/systemHospitalManager")
public class SystemHospitalManagerController {

    @Autowired
    private IHospitalService hospitalService;

    @ApiOperation("导入数据：将医院基础信息导出表信息导入到数据库中")
    @PostMapping("/putHospitalDataByExcel")
    public Result<Integer> putHospitalDataByExcel(@RequestParam("file") MultipartFile file) {
        int count;
        try {
            count = hospitalService.putHospitalDataByExcel(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.success(count);
    }

    @ApiOperation("导出文件：导出医院基础信息导入表模板")
    @GetMapping("/getExcelHospitalBasicInformationImportFormTemplate")
    public void getExcelHospitalBasicInformationImportFormTemplate(HttpServletResponse response) throws IOException {
        //设置 HTTP 响应头，指定文件名和 MIME 类型
        String fileNameUTF8;
        try {
            fileNameUTF8 = URLEncoder.encode("医院基础信息导入表(模板).xlsx", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameUTF8 + "\"");

        //获取模板文件输出流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("templates/医院基础信息导入表.xlsx");

        // 根据模板创建一个新Excel文件
        XSSFWorkbook excel = new XSSFWorkbook(in);

        //通过输出流将文件下载到客户端中
        ServletOutputStream out=response.getOutputStream();
        excel.write(out);

        //关闭资源
        in.close();
        excel.close();
        out.close();
    }

    @ApiOperation("导出文件：导出医院基础信息导出表")
    @GetMapping("/getExcelHospitalBasicInformationImportForm")
    public void getExcelHospitalBasicInformationImportForm(HttpServletResponse response) {
        hospitalService.getExcelHospitalBasicInformationImportForm(response);
    }

    @ApiOperation("根据医院名称，分页查询医院信息")
    @PostMapping("/pageSelectHospitalInfo")
    public Result<PageResult<Hospital>> pageSelectHospitalInfo(@RequestBody HospitalPageDTO hospitalPageDTO){
        PageResult<Hospital> pageResult = hospitalService.pageSelectHospitalInfo(hospitalPageDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("根据id修改医院信息")
    @PostMapping("/updateHospitalInfo")
    public Result updateHospitalInfo(@RequestBody Hospital hospital){
        hospitalService.updateById(hospital);
        return Result.success();
    }

    @ApiOperation("根据id输出医院信息")
    @GetMapping("/getHospitalInfo/{hospitalId}")
    public Result<Hospital> getHospitalInfo(@PathVariable Integer hospitalId){
        return Result.success(
                hospitalService.getById(hospitalId)
        );
    }

    @ApiOperation("根据id删除医院信息")
    @DeleteMapping("/deleteHospitalInfo/{hospitalId}")
    public Result deleteHospitalInfo(@PathVariable Integer hospitalId){
        boolean res = hospitalService.removeById(hospitalId);
        if(!res){
            return Result.error("该ID不存在");
        }
        return Result.success();
    }

}