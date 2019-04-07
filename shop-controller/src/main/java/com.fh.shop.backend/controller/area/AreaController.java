package com.fh.shop.backend.controller.area;

import com.fh.shop.backend.biz.area.IAreaService;
import com.fh.shop.backend.po.area.Area;
import com.fh.shop.backend.serverResponse.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {

    @Resource(name = "areaService" )
    private IAreaService areaService;

    @RequestMapping("findAreaList")
    @ResponseBody
    public ServerResponse findAreaList(Area area){
       List<Area> areaList = areaService.findAreaList(area);
        return ServerResponse.success(areaList);
    }
     @RequestMapping("toArea")
    public String toArea(){
        return "area/list";
    }
    @RequestMapping("addArea")
    @ResponseBody
    public ServerResponse addArea(Area area){
        areaService.addArea(area);
        return ServerResponse.success();
    }
}
