package com.fh.shop.backend.common;

import java.io.Serializable;
import java.util.List;

public class DataTableInfo implements Serializable {

    private static final long serialVersionUID = -8238403508690742364L;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List data;

    private  DataTableInfo (Integer draw, long recordsTotal, long recordsFiltered, List data){
           this.draw=draw;
           this.data=data;
           this.recordsTotal=recordsTotal;
           this.recordsFiltered=recordsFiltered;
    }

    public static DataTableInfo buildDataTable(Integer draw, long recordsTotal, long recordsFiltered, List data){
            return new DataTableInfo(draw, recordsTotal, recordsFiltered, data);
    }



    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
