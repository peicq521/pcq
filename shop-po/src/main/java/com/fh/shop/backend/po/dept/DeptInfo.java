package com.fh.shop.backend.po.dept;


import com.fh.shop.backend.po.Page;

import java.io.Serializable;

public class DeptInfo extends Page implements Serializable {

    private static final long serialVersionUID = 1344926966949649085L;
    private int  id;
    private String name;
    private int pId;
    private String remark;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
