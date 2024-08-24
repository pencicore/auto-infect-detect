package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Ethnicity {
    HAN("汉族"),
    TIBETAN("藏族"),
    YI("彝族"),
    OTHER("其他少数民族");

    @EnumValue
    private final String description;

    Ethnicity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Ethnicity fromDescription(String description) {
        for (Ethnicity ethnicity : values()) {
            if (ethnicity.getDescription().equals(description)) {
                return ethnicity;
            }
        }
        throw new IllegalArgumentException("Invalid description for Ethnicity: " + description);
    }
}

