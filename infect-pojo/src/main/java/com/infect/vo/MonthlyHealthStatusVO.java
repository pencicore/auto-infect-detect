package com.infect.vo;

public class MonthlyHealthStatusVO {
    private String date;

    private Boolean isDiagnose = false;
    private Boolean isExamine = false;
    private Boolean isHealth = false;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getDiagnose() {
        return isDiagnose;
    }

    public void setDiagnose(Boolean diagnose) {
        isDiagnose = diagnose;
    }

    public Boolean getExamine() {
        return isExamine;
    }

    public void setExamine(Boolean examine) {
        isExamine = examine;
    }

    public Boolean getHealth() {
        return isHealth;
    }

    public void setHealth(Boolean health) {
        isHealth = health;
    }

    @Override
    public String toString() {
        return "MonthlyHealthStatusVO{" +
                "date='" + date + '\'' +
                ", isDiagnose=" + isDiagnose +
                ", isExamine=" + isExamine +
                ", isHealth=" + isHealth +
                '}';
    }
}
