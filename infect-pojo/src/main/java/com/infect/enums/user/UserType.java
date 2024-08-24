package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum UserType {
    SYSTEM_ADMINISTRATOR("系统管理员"),
    RAILWAY_WORKER("铁路职工"),
    CDC_WORKER("疾控中心工作人员"),
    MEDICAL_STAFF("专职医护人员");

    @EnumValue
    private final String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static UserType fromDescription(String description) {
        for (UserType type : values()) {
            if (type.getDescription().equals(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid description for UserType: " + description);
    }
}

