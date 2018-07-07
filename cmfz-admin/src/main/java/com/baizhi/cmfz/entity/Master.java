package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by 姚亚博 on 2018/7/6.
 */
public class Master {
    private String masterId;
    @Excel(name="上师姓名",orderNum = "1",needMerge = true)
    private String masterName;
    private String masterPhoto;
    @Excel(name="上师简介",orderNum = "2",needMerge = true)
    private String masterSummary;

    public Master() {
    }

    public Master(String masterId, String masterName, String masterPhoto, String masterSummary) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}
