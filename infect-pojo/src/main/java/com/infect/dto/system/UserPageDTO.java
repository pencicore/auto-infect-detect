package com.infect.dto.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统管理员分页查询dto对象")
public class UserPageDTO {

    @ApiModelProperty(value = "用户类型", required = true, example = "铁路职工")
    private String userType;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "特殊职业", example = "医务人员")
    private String specificOccupation;

    @ApiModelProperty(value = "页码", example = "0")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public UserPageDTO() {
    }

    public UserPageDTO(String userType, String name, String phoneNumber, String department, String specificOccupation, Integer pageNo, Integer pageSize) {
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.specificOccupation = specificOccupation;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
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
     * @return specificOccupation
     */
    public String getSpecificOccupation() {
        return specificOccupation;
    }

    /**
     * 设置
     * @param specificOccupation
     */
    public void setSpecificOccupation(String specificOccupation) {
        this.specificOccupation = specificOccupation;
    }

    /**
     * 获取
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "UserPageDTO{userType = " + userType + ", name = " + name + ", phoneNumber = " + phoneNumber + ", department = " + department + ", specificOccupation = " + specificOccupation + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
