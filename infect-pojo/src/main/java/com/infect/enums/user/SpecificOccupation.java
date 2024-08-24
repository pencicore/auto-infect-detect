package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SpecificOccupation {
    NONE("否"),
    MEDICAL_PERSONNEL("医务人员"),
    PATHOGEN_DETECTION_PERSONNEL("病原微生物检测人员"),
    WILDLIFE_CONTACT_PERSONNEL("野生动物接触相关人员"),
    LIVESTOCK_FARMER("家禽、家畜养殖人员");

    @EnumValue
    private final String description;

    SpecificOccupation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SpecificOccupation fromDescription(String description) {
        for (SpecificOccupation occupation : values()) {
            if (occupation.getDescription().equals(description)) {
                return occupation;
            }
        }
        throw new IllegalArgumentException("Invalid description for SpecificOccupation: " + description);
    }
}