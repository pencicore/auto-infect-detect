package com.infect.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "infect.jwt")
public class JwtProperties {
    private String tokenName;
    private String railwayEmployeeSecretKey;
    private long railwayEmployeeTtl;
    private String adminSecretKey;
    private long adminTtl;
    private String cdcStaffSecretKey;
    private long cdcStaffTtl;
    private String medicalStaffSecretKey;
    private long medicalStaffTtl;

    public JwtProperties() {
    }

    public JwtProperties(String tokenName, String railwayEmployeeSecretKey, long railwayEmployeeTtl, String adminSecretKey, long adminTtl, String cdcStaffSecretKey, long cdcStaffTtl, String medicalStaffSecretKey, long medicalStaffTtl) {
        this.tokenName = tokenName;
        this.railwayEmployeeSecretKey = railwayEmployeeSecretKey;
        this.railwayEmployeeTtl = railwayEmployeeTtl;
        this.adminSecretKey = adminSecretKey;
        this.adminTtl = adminTtl;
        this.cdcStaffSecretKey = cdcStaffSecretKey;
        this.cdcStaffTtl = cdcStaffTtl;
        this.medicalStaffSecretKey = medicalStaffSecretKey;
        this.medicalStaffTtl = medicalStaffTtl;
    }

    /**
     * 获取
     * @return tokenName
     */
    public String getTokenName() {
        return tokenName;
    }

    /**
     * 设置
     * @param tokenName
     */
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    /**
     * 获取
     * @return railwayEmployeeSecretKey
     */
    public String getRailwayEmployeeSecretKey() {
        return railwayEmployeeSecretKey;
    }

    /**
     * 设置
     * @param railwayEmployeeSecretKey
     */
    public void setRailwayEmployeeSecretKey(String railwayEmployeeSecretKey) {
        this.railwayEmployeeSecretKey = railwayEmployeeSecretKey;
    }

    /**
     * 获取
     * @return railwayEmployeeTtl
     */
    public long getRailwayEmployeeTtl() {
        return railwayEmployeeTtl;
    }

    /**
     * 设置
     * @param railwayEmployeeTtl
     */
    public void setRailwayEmployeeTtl(long railwayEmployeeTtl) {
        this.railwayEmployeeTtl = railwayEmployeeTtl;
    }

    /**
     * 获取
     * @return adminSecretKey
     */
    public String getAdminSecretKey() {
        return adminSecretKey;
    }

    /**
     * 设置
     * @param adminSecretKey
     */
    public void setAdminSecretKey(String adminSecretKey) {
        this.adminSecretKey = adminSecretKey;
    }

    /**
     * 获取
     * @return adminTtl
     */
    public long getAdminTtl() {
        return adminTtl;
    }

    /**
     * 设置
     * @param adminTtl
     */
    public void setAdminTtl(long adminTtl) {
        this.adminTtl = adminTtl;
    }

    /**
     * 获取
     * @return cdcStaffSecretKey
     */
    public String getCdcStaffSecretKey() {
        return cdcStaffSecretKey;
    }

    /**
     * 设置
     * @param cdcStaffSecretKey
     */
    public void setCdcStaffSecretKey(String cdcStaffSecretKey) {
        this.cdcStaffSecretKey = cdcStaffSecretKey;
    }

    /**
     * 获取
     * @return cdcStaffTtl
     */
    public long getCdcStaffTtl() {
        return cdcStaffTtl;
    }

    /**
     * 设置
     * @param cdcStaffTtl
     */
    public void setCdcStaffTtl(long cdcStaffTtl) {
        this.cdcStaffTtl = cdcStaffTtl;
    }

    /**
     * 获取
     * @return medicalStaffSecretKey
     */
    public String getMedicalStaffSecretKey() {
        return medicalStaffSecretKey;
    }

    /**
     * 设置
     * @param medicalStaffSecretKey
     */
    public void setMedicalStaffSecretKey(String medicalStaffSecretKey) {
        this.medicalStaffSecretKey = medicalStaffSecretKey;
    }

    /**
     * 获取
     * @return medicalStaffTtl
     */
    public long getMedicalStaffTtl() {
        return medicalStaffTtl;
    }

    /**
     * 设置
     * @param medicalStaffTtl
     */
    public void setMedicalStaffTtl(long medicalStaffTtl) {
        this.medicalStaffTtl = medicalStaffTtl;
    }

    public String toString() {
        return "JwtProperties{tokenName = " + tokenName + ", railwayEmployeeSecretKey = " + railwayEmployeeSecretKey + ", railwayEmployeeTtl = " + railwayEmployeeTtl + ", adminSecretKey = " + adminSecretKey + ", adminTtl = " + adminTtl + ", cdcStaffSecretKey = " + cdcStaffSecretKey + ", cdcStaffTtl = " + cdcStaffTtl + ", medicalStaffSecretKey = " + medicalStaffSecretKey + ", medicalStaffTtl = " + medicalStaffTtl + "}";
    }
}
