package com.baizhi.cmfz.entity;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
public class Rich {
     private Integer errno;
     private List<String> data;

    public Rich() {
    }

    public Rich(Integer errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Rich{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }
}
