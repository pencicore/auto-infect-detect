package com.infect.controller.common;

import com.infect.dto.DiagnosisReportsDTO;
import com.infect.dto.LabTestFileDTO;
import com.infect.entity.Diagnosisreports;
import com.infect.entity.Labtestfiles;
import com.infect.properties.PathProperties;
import com.infect.result.Result;
import com.infect.service.IDiagnosisreportsService;
import com.infect.service.ILabtestfilesService;
import com.infect.service.MyDiagnosisService;
import com.infect.service.MyLabTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Api(tags = "文件相关接口")
@RestController
@RequestMapping("/common/file")
public class FileController {

    @Autowired
    private MyDiagnosisService diagnosisService;

    @Autowired
    private MyLabTestService labTestService;

    @Autowired
    private IDiagnosisreportsService diagnosisreportsService;

    @Autowired
    private ILabtestfilesService labtestfilesService;

    @Autowired
    private PathProperties pathProperties;

    @ApiOperation(value = "提交诊断报告文件")
    @PostMapping("/saveDiagnosisReport")
    public Result<Integer> uploadReportFile(@ModelAttribute DiagnosisReportsDTO diagnosisReportsDTO){
        Integer reportId = diagnosisService.uploadReportFile(diagnosisReportsDTO);
        System.out.println(reportId);
        return Result.success(reportId);
    }

    @ApiOperation(value = "提交实验文件")
    @PostMapping("/saveLabTestFile")
    public Result<Integer> uploadLabTestFile(@ModelAttribute LabTestFileDTO labTestFileDTO){
        Integer labTestId = labTestService.uploadLabTestFile(labTestFileDTO);
        return Result.success(labTestId);
    }

    @ApiOperation(value = "根据报告id获取诊断报告文件")
    @GetMapping("/getDiagnosisReport/{reportId}")
    public void getDiagnosisReport(@PathVariable Integer reportId, HttpServletResponse response) throws UnsupportedEncodingException {
        Diagnosisreports diagnosisreports = diagnosisreportsService.getById(reportId);
        if (diagnosisreports == null) {
            throw new RuntimeException("报告不存在");
        }
        // 获取文件路径和文件名
        String filePath = diagnosisreports.getFilePath();
        String fileName = diagnosisreports.getFileName();
        // 创建文件对象
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        // 设置响应头，通知浏览器下载文件
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        try (
                // 创建输入流读取文件
                FileInputStream fis = new FileInputStream(file);
                // 创建输出流返回文件
                OutputStream os = response.getOutputStream()
        ) {
            // 缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 将文件写入输出流
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            // 刷新输出流
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件下载失败");
        }
    }

    @ApiOperation(value = "根据检查文件id获取检查文件")
    @GetMapping("/getLabTestFile/{labTestId}")
    public void getLabTestFile(@PathVariable Integer labTestId, HttpServletResponse response) throws UnsupportedEncodingException {
        Labtestfiles labtestfiles = labtestfilesService.getById(labTestId);
        if (labtestfiles == null) {
            throw new RuntimeException("报告不存在");
        }
        // 获取文件路径和文件名
        String filePath = labtestfiles.getFilePath();
        String fileName = labtestfiles.getFileName();
        // 创建文件对象
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        // 设置响应头，通知浏览器下载文件
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        try (
                // 创建输入流读取文件
                FileInputStream fis = new FileInputStream(file);
                // 创建输出流返回文件
                OutputStream os = response.getOutputStream()
        ) {
            // 缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 将文件写入输出流
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            // 刷新输出流
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件下载失败");
        }
    }


    @ApiOperation("根据文件名，获取疾病宣传资料文件")
    @GetMapping("getLearningMaterialFile/{filename}")
    public ResponseEntity<Resource> getLearningMaterialFile(@PathVariable String filename) {
        // 获取文件路径
        Path filePath = Paths.get(System.getProperty("user.dir") + "/" + pathProperties.getDiseaseLearningMaterialPath() + "/" + filename);
        System.out.println(filePath);
        try {
            // 加载文件资源
            Resource resource = new UrlResource(filePath.toUri());
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 自动检测文件的Content-Type
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                // 如果无法检测到文件类型，设置为通用二进制流类型
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType)) // 设置具体的媒体类型
                    .body(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
