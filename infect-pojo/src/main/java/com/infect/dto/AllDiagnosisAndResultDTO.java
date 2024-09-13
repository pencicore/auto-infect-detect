package com.infect.dto;

import com.infect.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ApiModel("诊断结果和所有诊断信息")
public class AllDiagnosisAndResultDTO {

    //诊断结果dto
    private DiagnosisResultsEmpDTO diagnosisResultsEmpDTO;

    //诊断信息entity
    private Diagnosispersonalinfo diagnosispersonalinfo;

    private Diagnosisgeneralsymptoms diagnosisgeneralsymptoms;

    private Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms;

    private Diagnosisdigestivesymptoms diagnosisdigestivesymptoms;

    private Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms;

    private Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms;

    private Diagnosislocalsymptoms diagnosislocalsymptoms;

    private Diagnosisothersymptoms diagnosisothersymptoms;

    private Diagnosiscomplications diagnosiscomplications;

    //检查项目表
    private Diagnosisexaminations diagnosisexaminations;

    //报告文件
    @ApiModelProperty("诊断报告文件数组")
    private List<Integer> fileIdList;

    public DiagnosisResultsEmpDTO getDiagnosisResultsEmpDTO() {
        return diagnosisResultsEmpDTO;
    }

    public void setDiagnosisResultsEmpDTO(DiagnosisResultsEmpDTO diagnosisResultsEmpDTO) {
        this.diagnosisResultsEmpDTO = diagnosisResultsEmpDTO;
    }

    public Diagnosispersonalinfo getDiagnosispersonalinfo() {
        return diagnosispersonalinfo;
    }

    public void setDiagnosispersonalinfo(Diagnosispersonalinfo diagnosispersonalinfo) {
        this.diagnosispersonalinfo = diagnosispersonalinfo;
    }

    public Diagnosisgeneralsymptoms getDiagnosisgeneralsymptoms() {
        return diagnosisgeneralsymptoms;
    }

    public void setDiagnosisgeneralsymptoms(Diagnosisgeneralsymptoms diagnosisgeneralsymptoms) {
        this.diagnosisgeneralsymptoms = diagnosisgeneralsymptoms;
    }

    public Diagnosisrespiratorysymptoms getDiagnosisrespiratorysymptoms() {
        return diagnosisrespiratorysymptoms;
    }

    public void setDiagnosisrespiratorysymptoms(Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms) {
        this.diagnosisrespiratorysymptoms = diagnosisrespiratorysymptoms;
    }

    public Diagnosisdigestivesymptoms getDiagnosisdigestivesymptoms() {
        return diagnosisdigestivesymptoms;
    }

    public void setDiagnosisdigestivesymptoms(Diagnosisdigestivesymptoms diagnosisdigestivesymptoms) {
        this.diagnosisdigestivesymptoms = diagnosisdigestivesymptoms;
    }

    public Diagnosiscirculatorysymptoms getDiagnosiscirculatorysymptoms() {
        return diagnosiscirculatorysymptoms;
    }

    public void setDiagnosiscirculatorysymptoms(Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms) {
        this.diagnosiscirculatorysymptoms = diagnosiscirculatorysymptoms;
    }

    public Diagnosisneurologicalsymptoms getDiagnosisneurologicalsymptoms() {
        return diagnosisneurologicalsymptoms;
    }

    public void setDiagnosisneurologicalsymptoms(Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms) {
        this.diagnosisneurologicalsymptoms = diagnosisneurologicalsymptoms;
    }

    public Diagnosislocalsymptoms getDiagnosislocalsymptoms() {
        return diagnosislocalsymptoms;
    }

    public void setDiagnosislocalsymptoms(Diagnosislocalsymptoms diagnosislocalsymptoms) {
        this.diagnosislocalsymptoms = diagnosislocalsymptoms;
    }

    public Diagnosisothersymptoms getDiagnosisothersymptoms() {
        return diagnosisothersymptoms;
    }

    public void setDiagnosisothersymptoms(Diagnosisothersymptoms diagnosisothersymptoms) {
        this.diagnosisothersymptoms = diagnosisothersymptoms;
    }

    public Diagnosiscomplications getDiagnosiscomplications() {
        return diagnosiscomplications;
    }

    public void setDiagnosiscomplications(Diagnosiscomplications diagnosiscomplications) {
        this.diagnosiscomplications = diagnosiscomplications;
    }

    public Diagnosisexaminations getDiagnosisexaminations() {
        return diagnosisexaminations;
    }

    public void setDiagnosisexaminations(Diagnosisexaminations diagnosisexaminations) {
        this.diagnosisexaminations = diagnosisexaminations;
    }

    public List<Integer> getFileIdList() {
        return fileIdList;
    }

    public void setFileIdList(List<Integer> fileIdList) {
        this.fileIdList = fileIdList;
    }

    @Override
    public String toString() {
        return "AllDiagnosisAndResultDTO{" +
                "diagnosisResultsEmpDTO=" + diagnosisResultsEmpDTO +
                ", diagnosispersonalinfo=" + diagnosispersonalinfo +
                ", diagnosisgeneralsymptoms=" + diagnosisgeneralsymptoms +
                ", diagnosisrespiratorysymptoms=" + diagnosisrespiratorysymptoms +
                ", diagnosisdigestivesymptoms=" + diagnosisdigestivesymptoms +
                ", diagnosiscirculatorysymptoms=" + diagnosiscirculatorysymptoms +
                ", diagnosisneurologicalsymptoms=" + diagnosisneurologicalsymptoms +
                ", diagnosislocalsymptoms=" + diagnosislocalsymptoms +
                ", diagnosisothersymptoms=" + diagnosisothersymptoms +
                ", diagnosiscomplications=" + diagnosiscomplications +
                ", diagnosisexaminations=" + diagnosisexaminations +
                ", fileIdList=" + fileIdList +
                '}';
    }
}
