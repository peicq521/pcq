/**
 * <pre>项目名称:shop_admin_v2
 * 文件名称:BrandController.java
 * 包名:com.fh.shop.backend.web.controller.brand
 * 创建日期:2018年12月27日下午11:32:52
 * Copyright (c) 2018, 1090273251@163.com All Rights Reserved.</pre>
 */
package com.fh.shop.backend.controller.brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.fh.shop.backend.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.po.brand.Brand;
import com.fh.shop.backend.serverResponse.ServerResponse;

/**
 * <pre>项目名称：shop_admin_v2     
 * 类名称：BrandController    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2018年12月27日 下午11:32:52    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2018年12月27日 下午11:32:52    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    private static final Logger LOG = LoggerFactory.getLogger(BrandController.class);

    @Resource(name = "brandService")
    private IBrandService brandService;

    @RequestMapping("toAdd")
    public String toAdd() {

        return "brand/addBrand";
    }

    @RequestMapping("addBrand")
    @ResponseBody
    public ServerResponse addBrand(Brand brand) {
        brandService.addBrand(brand);
        return ServerResponse.success();

    }

    @RequestMapping("findList")
    @ResponseBody
    public ServerResponse findList() {
        List<Brand> list = brandService.queryBrand();
        return ServerResponse.success(list);
    }

    @RequestMapping("queryBrandPage")
    @ResponseBody
    public Map<Object, Object> queryBrandPage(Brand brand, Integer draw, Integer start, Integer length,
                                              HttpServletRequest request) {
        Map<Object, Object> resultMap = new HashMap<>();
        String orderNumber = request.getParameter("order[0][column]");
        String orderDircept = request.getParameter("order[0][dir]");
        String orderName = request.getParameter("columns[" + orderNumber + "][data]");
        brand.setSortField(orderName);
        brand.setSort(orderDircept);
        if(brand.getSortField().equals("entryTimeStr")){
            brand.setSortField("entryTime");
        }
        if(brand.getSortField().equals("updateTimeStr")){
            brand.setSortField("updateTime");
        }
        Long count = brandService.queryCount(brand);
        brand.setStartPos(start);
        brand.setPageSize(length);
        List<Brand> list = brandService.queryBrandPage(brand);
        for (Brand brand1 : list) {
            brand1.setEntryTimeStr(DateUtil.date2Str(brand1.getEntryTime(), DateUtil.L_M_D_H_M_S));
            brand1.setUpdateTimeStr(DateUtil.date2Str(brand1.getUpdateTime(), DateUtil.L_M_D_H_M_S));
        }

        resultMap.put("draw", draw);
        resultMap.put("recordsTotal", count);
        resultMap.put("recordsFiltered", count);
        resultMap.put("data", list);
        return resultMap;
    }

    @RequestMapping("findBrand")
    public ModelAndView findBrand(Integer id) {
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("brand/showBrand");

        Brand brand = brandService.findBrand(id);

        modelAndView.addObject("brand", brand);

        return modelAndView;
    }

    @RequestMapping("updateBrand")
    @ResponseBody
    public ServerResponse updateBrand(Brand brand) {
        brandService.updateBrand(brand);
        return ServerResponse.success();
    }

    @RequestMapping("deleteBrand")
    @ResponseBody
    public ServerResponse deleteBrand(Integer id) {
        brandService.deleteBrand(id);
        return ServerResponse.success();
    }

    @RequestMapping("deleteBechBrand")
    @ResponseBody
    public ServerResponse deleteBechBrand(String ids) {
        brandService.deleteBechBrand(ids);
        return ServerResponse.success();
    }

    @RequestMapping("toBrand")
    public String toBrand() {
        return "brand/showBrand";
    }


}
