package com.baizhi.cmfz.entity;

/**
 * @Description 管理员Manager的实体类
 * Created by 姚亚博 on 2018/7/4.
 */
public class Manager {
    private String mgr_id;
    private String mgr_name;
    private String mgr_pwd;
    private String salt;
    private String mgr_status;

    public Manager() {
    }

    public Manager(String mgr_id, String mgr_name, String mgr_pwd, String salt, String mgr_status) {
        this.mgr_id = mgr_id;
        this.mgr_name = mgr_name;
        this.mgr_pwd = mgr_pwd;
        this.salt = salt;
        this.mgr_status = mgr_status;
    }

    public String getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getMgr_name() {
        return mgr_name;
    }

    public void setMgr_name(String mgr_name) {
        this.mgr_name = mgr_name;
    }

    public String getMgr_pwd() {
        return mgr_pwd;
    }

    public void setMgr_pwd(String mgr_pwd) {
        this.mgr_pwd = mgr_pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMgr_status() {
        return mgr_status;
    }

    public void setMgr_status(String mgr_status) {
        this.mgr_status = mgr_status;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgr_id='" + mgr_id + '\'' +
                ", mgr_name='" + mgr_name + '\'' +
                ", mgr_pwd='" + mgr_pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", mgr_status='" + mgr_status + '\'' +
                '}';
    }
}
