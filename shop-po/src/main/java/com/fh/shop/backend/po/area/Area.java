package com.fh.shop.backend.po.area;

import com.fh.shop.backend.po.Page;

import java.io.Serializable;

public class Area extends Page implements Serializable {
    private static final long serialVersionUID = -5441364763295128171L;

    private int id;
    private int pId;
    private String name;
    private int typeId;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

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
}
