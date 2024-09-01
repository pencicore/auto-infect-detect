package com.infect.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
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

}
