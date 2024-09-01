package com.infect.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "infect.path")
public class PathProperties {
    private String diagnosisFilePath;
}
