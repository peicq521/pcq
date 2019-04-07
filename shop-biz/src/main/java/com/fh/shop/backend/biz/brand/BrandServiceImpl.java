/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:BrandServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.brand 
 * 创建日期:2018年12月27日下午11:56:57 
 * Copyright (c) 2018, 1090273251@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.biz.brand;

import com.fh.shop.backend.mapper.brand.IBrandMapper;
import com.fh.shop.backend.po.brand.Brand;
import com.fh.util.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>项目名称：shop_admin_v2   
 * 类名称：BrandServiceImpl    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2018年12月27日 下午11:56:57    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2018年12月27日 下午11:56:57    
 * 修改备注：       
 * @version </pre>    
 */
@Service("brandService")
public class BrandServiceImpl implements IBrandService{
	
	@Autowired
	private IBrandMapper brandMapper;
	
	public Date getDateNow(){
		Date now = new Date();
		return now;
	}
	

	public void addBrand(Brand brand) {
	
		brand.setEntryTime(getDateNow());
		brand.setUpdateTime(getDateNow());
		brandMapper.addBrand(brand);
	}


	public List<Brand> queryBrandPage(Brand brand) {
		String brandList = RedisUtil.get("brandList");
		Gson gson = new Gson();
		if(StringUtils.isEmpty(brandList)){
			 List<Brand> queryBrandPage = brandMapper.queryBrandPage(brand);
			String result = gson.toJson(queryBrandPage);
			 RedisUtil.set("brandList", result);
			return queryBrandPage ;
		}else {
			List<Brand> brandList1 = gson.fromJson(brandList,new TypeToken<List<Brand>>(){}.getType());
 			return brandList1;
		}
	}


	public Long queryCount(Brand brand) {
		
		Long queryCount = brandMapper.queryCount(brand);
		
		return queryCount;
	}

	

	public Brand findBrand(Integer id) {
		
		Brand findBrand = brandMapper.findBrand(id);
		
		return findBrand;
	}

	

	public void updateBrand(Brand brand) {
		
		brand.setUpdateTime(getDateNow());

		brandMapper.updateBrand(brand);
		
	}


	public void deleteBrand(Integer id) {
		

		brandMapper.deleteBrand(id);
	}

	

	public void deleteBechBrand(String ids) {

		String[] idsList = ids.split(",");
		
		List<Integer> idList = new ArrayList<Integer>();
		
		for (String id : idsList) {
			
			idList.add(Integer.valueOf(id));
		}
		
		brandMapper.deleteBechBrand(idList);
	}


	public List<Brand> queryBrand() {
		
		List<Brand> queryBrand = brandMapper.queryBrand();
		
		return queryBrand;
	}

}
