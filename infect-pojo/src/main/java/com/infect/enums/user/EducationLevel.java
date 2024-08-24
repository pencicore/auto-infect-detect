package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum EducationLevel {
    BELOW_PRIMARY("小学及以下"),
    MIDDLE_SCHOOL("初中"),
    TECHNICAL_HS("中专/高中"),
    COLLEGE_UNDERGRAD("大专/本科"),
    MASTER_AND_ABOVE("硕士及以上");

    @EnumValue
    private final String description;

    EducationLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EducationLevel fromDescription(String description) {
        for (EducationLevel level : values()) {
            if (level.getDescription().equals(description)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid description for EducationLevel: " + description);
    }
}

