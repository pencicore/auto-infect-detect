package com.infect.entity.armorFusion;

import com.infect.entity.*;

import java.util.List;

public class AllDiagnosis {

    //诊断结果dto
    private Diagnosisresults diagnosisresults;

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
    private List<Integer> fileIdList;

    public AllDiagnosis() {
    }

    public AllDiagnosis(Diagnosisresults diagnosisresults, Diagnosispersonalinfo diagnosispersonalinfo, Diagnosisgeneralsymptoms diagnosisgeneralsymptoms, Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms, Diagnosisdigestivesymptoms diagnosisdigestivesymptoms, Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms, Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms, Diagnosislocalsymptoms diagnosislocalsymptoms, Diagnosisothersymptoms diagnosisothersymptoms, Diagnosiscomplications diagnosiscomplications, Diagnosisexaminations diagnosisexaminations, List<Integer> fileIdList) {
        this.diagnosisresults = diagnosisresults;
        this.diagnosispersonalinfo = diagnosispersonalinfo;
        this.diagnosisgeneralsymptoms = diagnosisgeneralsymptoms;
        this.diagnosisrespiratorysymptoms = diagnosisrespiratorysymptoms;
        this.diagnosisdigestivesymptoms = diagnosisdigestivesymptoms;
        this.diagnosiscirculatorysymptoms = diagnosiscirculatorysymptoms;
        this.diagnosisneurologicalsymptoms = diagnosisneurologicalsymptoms;
        this.diagnosislocalsymptoms = diagnosislocalsymptoms;
        this.diagnosisothersymptoms = diagnosisothersymptoms;
        this.diagnosiscomplications = diagnosiscomplications;
        this.diagnosisexaminations = diagnosisexaminations;
        this.fileIdList = fileIdList;
    }

    /**
     * 获取
     * @return diagnosisresults
     */
    public Diagnosisresults getDiagnosisresults() {
        return diagnosisresults;
    }

    /**
     * 设置
     * @param diagnosisresults
     */
    public void setDiagnosisresults(Diagnosisresults diagnosisresults) {
        this.diagnosisresults = diagnosisresults;
    }

    /**
     * 获取
     * @return diagnosispersonalinfo
     */
    public Diagnosispersonalinfo getDiagnosispersonalinfo() {
        return diagnosispersonalinfo;
    }

    /**
     * 设置
     * @param diagnosispersonalinfo
     */
    public void setDiagnosispersonalinfo(Diagnosispersonalinfo diagnosispersonalinfo) {
        this.diagnosispersonalinfo = diagnosispersonalinfo;
    }

    /**
     * 获取
     * @return diagnosisgeneralsymptoms
     */
    public Diagnosisgeneralsymptoms getDiagnosisgeneralsymptoms() {
        return diagnosisgeneralsymptoms;
    }

    /**
     * 设置
     * @param diagnosisgeneralsymptoms
     */
    public void setDiagnosisgeneralsymptoms(Diagnosisgeneralsymptoms diagnosisgeneralsymptoms) {
        this.diagnosisgeneralsymptoms = diagnosisgeneralsymptoms;
    }

    /**
     * 获取
     * @return diagnosisrespiratorysymptoms
     */
    public Diagnosisrespiratorysymptoms getDiagnosisrespiratorysymptoms() {
        return diagnosisrespiratorysymptoms;
    }

    /**
     * 设置
     * @param diagnosisrespiratorysymptoms
     */
    public void setDiagnosisrespiratorysymptoms(Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms) {
        this.diagnosisrespiratorysymptoms = diagnosisrespiratorysymptoms;
    }

    /**
     * 获取
     * @return diagnosisdigestivesymptoms
     */
    public Diagnosisdigestivesymptoms getDiagnosisdigestivesymptoms() {
        return diagnosisdigestivesymptoms;
    }

    /**
     * 设置
     * @param diagnosisdigestivesymptoms
     */
    public void setDiagnosisdigestivesymptoms(Diagnosisdigestivesymptoms diagnosisdigestivesymptoms) {
        this.diagnosisdigestivesymptoms = diagnosisdigestivesymptoms;
    }

    /**
     * 获取
     * @return diagnosiscirculatorysymptoms
     */
    public Diagnosiscirculatorysymptoms getDiagnosiscirculatorysymptoms() {
        return diagnosiscirculatorysymptoms;
    }

    /**
     * 设置
     * @param diagnosiscirculatorysymptoms
     */
    public void setDiagnosiscirculatorysymptoms(Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms) {
        this.diagnosiscirculatorysymptoms = diagnosiscirculatorysymptoms;
    }

    /**
     * 获取
     * @return diagnosisneurologicalsymptoms
     */
    public Diagnosisneurologicalsymptoms getDiagnosisneurologicalsymptoms() {
        return diagnosisneurologicalsymptoms;
    }

    /**
     * 设置
     * @param diagnosisneurologicalsymptoms
     */
    public void setDiagnosisneurologicalsymptoms(Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms) {
        this.diagnosisneurologicalsymptoms = diagnosisneurologicalsymptoms;
    }

    /**
     * 获取
     * @return diagnosislocalsymptoms
     */
    public Diagnosislocalsymptoms getDiagnosislocalsymptoms() {
        return diagnosislocalsymptoms;
    }

    /**
     * 设置
     * @param diagnosislocalsymptoms
     */
    public void setDiagnosislocalsymptoms(Diagnosislocalsymptoms diagnosislocalsymptoms) {
        this.diagnosislocalsymptoms = diagnosislocalsymptoms;
    }

    /**
     * 获取
     * @return diagnosisothersymptoms
     */
    public Diagnosisothersymptoms getDiagnosisothersymptoms() {
        return diagnosisothersymptoms;
    }

    /**
     * 设置
     * @param diagnosisothersymptoms
     */
    public void setDiagnosisothersymptoms(Diagnosisothersymptoms diagnosisothersymptoms) {
        this.diagnosisothersymptoms = diagnosisothersymptoms;
    }

    /**
     * 获取
     * @return diagnosiscomplications
     */
    public Diagnosiscomplications getDiagnosiscomplications() {
        return diagnosiscomplications;
    }

    /**
     * 设置
     * @param diagnosiscomplications
     */
    public void setDiagnosiscomplications(Diagnosiscomplications diagnosiscomplications) {
        this.diagnosiscomplications = diagnosiscomplications;
    }

    /**
     * 获取
     * @return diagnosisexaminations
     */
    public Diagnosisexaminations getDiagnosisexaminations() {
        return diagnosisexaminations;
    }

    /**
     * 设置
     * @param diagnosisexaminations
     */
    public void setDiagnosisexaminations(Diagnosisexaminations diagnosisexaminations) {
        this.diagnosisexaminations = diagnosisexaminations;
    }

    /**
     * 获取
     * @return fileIdList
     */
    public List<Integer> getFileIdList() {
        return fileIdList;
    }

    /**
     * 设置
     * @param fileIdList
     */
    public void setFileIdList(List<Integer> fileIdList) {
        this.fileIdList = fileIdList;
    }

    public String toString() {
        return "AllDiagnosis{diagnosisresults = " + diagnosisresults + ", diagnosispersonalinfo = " + diagnosispersonalinfo + ", diagnosisgeneralsymptoms = " + diagnosisgeneralsymptoms + ", diagnosisrespiratorysymptoms = " + diagnosisrespiratorysymptoms + ", diagnosisdigestivesymptoms = " + diagnosisdigestivesymptoms + ", diagnosiscirculatorysymptoms = " + diagnosiscirculatorysymptoms + ", diagnosisneurologicalsymptoms = " + diagnosisneurologicalsymptoms + ", diagnosislocalsymptoms = " + diagnosislocalsymptoms + ", diagnosisothersymptoms = " + diagnosisothersymptoms + ", diagnosiscomplications = " + diagnosiscomplications + ", diagnosisexaminations = " + diagnosisexaminations + ", fileIdList = " + fileIdList + "}";
    }
}
