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

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getRailwayEmployeeSecretKey() {
        return railwayEmployeeSecretKey;
    }

    public void setRailwayEmployeeSecretKey(String railwayEmployeeSecretKey) {
        this.railwayEmployeeSecretKey = railwayEmployeeSecretKey;
    }

    public long getRailwayEmployeeTtl() {
        return railwayEmployeeTtl;
    }

    public void setRailwayEmployeeTtl(long railwayEmployeeTtl) {
        this.railwayEmployeeTtl = railwayEmployeeTtl;
    }

    public String getAdminSecretKey() {
        return adminSecretKey;
    }

    public void setAdminSecretKey(String adminSecretKey) {
        this.adminSecretKey = adminSecretKey;
    }

    public long getAdminTtl() {
        return adminTtl;
    }

    public void setAdminTtl(long adminTtl) {
        this.adminTtl = adminTtl;
    }

    public String getCdcStaffSecretKey() {
        return cdcStaffSecretKey;
    }

    public void setCdcStaffSecretKey(String cdcStaffSecretKey) {
        this.cdcStaffSecretKey = cdcStaffSecretKey;
    }

    public long getCdcStaffTtl() {
        return cdcStaffTtl;
    }

    public void setCdcStaffTtl(long cdcStaffTtl) {
        this.cdcStaffTtl = cdcStaffTtl;
    }

    public String getMedicalStaffSecretKey() {
        return medicalStaffSecretKey;
    }

    public void setMedicalStaffSecretKey(String medicalStaffSecretKey) {
        this.medicalStaffSecretKey = medicalStaffSecretKey;
    }

    public long getMedicalStaffTtl() {
        return medicalStaffTtl;
    }

    public void setMedicalStaffTtl(long medicalStaffTtl) {
        this.medicalStaffTtl = medicalStaffTtl;
    }
}
