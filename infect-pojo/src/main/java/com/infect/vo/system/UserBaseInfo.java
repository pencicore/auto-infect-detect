package com.infect.vo.system;

import io.swagger.annotations.ApiModelProperty;

public class UserBaseInfo {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "30")
    private Integer age;

    @ApiModelProperty(value = "民族", example = "汉族")
    private String ethnicity;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;


    public UserBaseInfo() {
    }

    public UserBaseInfo(Integer userId, String name, String gender, Integer age, String ethnicity, String department, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ethnicity = ethnicity;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return ethnicity
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * 设置
     * @param ethnicity
     */
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    /**
     * 获取
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "UserBaseInfo{userId = " + userId + ", name = " + name + ", gender = " + gender + ", age = " + age + ", ethnicity = " + ethnicity + ", department = " + department + ", phoneNumber = " + phoneNumber + "}";
    }
}
