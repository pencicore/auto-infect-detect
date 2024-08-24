package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum MedicalPersonnelType {
    DOCTOR("医生"),
    NURSE("护士"),
    FIELD_WORKER("疾控现场工作人员"),
    LABORATORY_TESTER("实验室检测人员"),
    OTHER("其他");

    @EnumValue
    private final String description;

    MedicalPersonnelType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MedicalPersonnelType fromDescription(String description) {
        for (MedicalPersonnelType type : values()) {
            if (type.getDescription().equals(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid description for MedicalPersonnelType: " + description);
    }
}
