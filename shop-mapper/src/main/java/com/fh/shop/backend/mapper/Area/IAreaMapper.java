package com.fh.shop.backend.mapper.Area;

import com.fh.shop.backend.po.area.Area;

import java.util.List;

public interface IAreaMapper {
    List<Area> findAreaList(Area area);

    void addArea(Area area);
}
