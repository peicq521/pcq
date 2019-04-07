package com.fh.shop.backend.biz.area;

import com.fh.shop.backend.mapper.Area.IAreaMapper;
import com.fh.shop.backend.po.area.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService{
    @Autowired
    private IAreaMapper areaMapper;

    @Override
    public List<Area> findAreaList(Area area) {
        List<Area> areaList = areaMapper.findAreaList(area);
        return areaList;
    }

    @Override
    public void addArea(Area area) {
        areaMapper.addArea(area);
    }
}
