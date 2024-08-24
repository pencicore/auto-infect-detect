package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Gender {
    MALE("男"),
    FEMALE("女");

    @EnumValue
    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Gender fromDescription(String description) {
        for (Gender gender : values()) {
            if (gender.getDescription().equals(description)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid description for Gender: " + description);
    }
}

