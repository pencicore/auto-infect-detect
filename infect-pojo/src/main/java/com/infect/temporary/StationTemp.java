package com.infect.temporary;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class StationTemp {

    private BigDecimal longitude;

    private BigDecimal latitude;


    public StationTemp() {
    }

    public StationTemp(BigDecimal longitude, BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * 获取
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return "StationTemp{longitude = " + longitude + ", latitude = " + latitude + "}";
    }
}
