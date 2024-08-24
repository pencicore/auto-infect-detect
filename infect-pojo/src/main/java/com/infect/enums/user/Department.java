package com.infect.enums.user;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Department {
    SAFETY("安全部"),
    FINANCE("财务部"),
    MEASUREMENT("测量队"),
    ENGINEERING_TECHNOLOGY("工程技术部"),
    CONTRACT("合约部"),
    LAB("试验室"),
    MATERIALS("物资设备部"),
    PROJECT_MANAGEMENT("项目管理层"),
    RELOCATION_COORDINATION("征拆协调部"),
    GENERAL_MANAGEMENT("综合管理部");

    @EnumValue
    private final String description;

    Department(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Department fromDescription(String description) {
        for (Department dept : values()) {
            if (dept.getDescription().equals(description)) {
                return dept;
            }
        }
        throw new IllegalArgumentException("Invalid description for Department: " + description);
    }
}

