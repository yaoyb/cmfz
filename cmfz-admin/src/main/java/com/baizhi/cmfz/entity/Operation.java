package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
public class Operation {
    private String operationId;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")//相应
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//请求
    private Date operationTime;
    private String operationResource;
    private String operationAction;
    private String operationMassage;
    private String operationResult;
    private Manager manager;

    public Operation() {
    }

    public Operation(String operationId, Date operationTime, String operationResource, String operationAction, String operationMassage, String operationResult, Manager manager) {
        this.operationId = operationId;
        this.operationTime = operationTime;
        this.operationResource = operationResource;
        this.operationAction = operationAction;
        this.operationMassage = operationMassage;
        this.operationResult = operationResult;
        this.manager = manager;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationResource() {
        return operationResource;
    }

    public void setOperationResource(String operationResource) {
        this.operationResource = operationResource;
    }

    public String getOperationAction() {
        return operationAction;
    }

    public void setOperationAction(String operationAction) {
        this.operationAction = operationAction;
    }

    public String getOperationMassage() {
        return operationMassage;
    }

    public void setOperationMassage(String operationMassage) {
        this.operationMassage = operationMassage;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId='" + operationId + '\'' +
                ", operationTime=" + operationTime +
                ", operationResource='" + operationResource + '\'' +
                ", operationAction='" + operationAction + '\'' +
                ", operationMassage='" + operationMassage + '\'' +
                ", operationResult='" + operationResult + '\'' +
                ", manager=" + manager +
                '}';
    }
}
