package com.fh.shop.backend.biz.area;

import com.fh.shop.backend.po.area.Area;

import java.util.List;

public interface IAreaService {
    /**
     * @param area
     * @return
     */
    List<Area> findAreaList(Area area);

    void addArea(Area area);
}
