package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum DrinkingStatus {
    NON_DRINKER("不喝酒"),
    OCCASIONAL_DRINKER("偶尔喝酒（小于3次/周）"),
    FREQUENT_DRINKER("经常喝酒（大于等于3次/周）"),
    HEAVY_DRINKER("经常大量喝酒（白酒≥3次/周，每次≥2两）");

    @EnumValue
    private final String description;

    DrinkingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static DrinkingStatus fromDescription(String description) {
        for (DrinkingStatus status : values()) {
            if (status.getDescription().equals(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description for DrinkingStatus: " + description);
    }
}

