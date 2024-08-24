package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SmokingStatus {
    CURRENTLY_SMOKING("现在吸"),
    FORMERLY_SMOKED("以前吸"),
    NEVER_SMOKED("从不吸");

    @EnumValue
    private final String description;

    SmokingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SmokingStatus fromDescription(String description) {
        for (SmokingStatus status : values()) {
            if (status.getDescription().equals(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description for SmokingStatus: " + description);
    }
}

