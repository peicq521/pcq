/** 
 * <pre>项目名称:shop_admin_v2  
 * 文件名称:Brand.java 
 * 包名:com.fh.shop.backend.po.brand 
 * 创建日期:2018年12月27日下午2:37:30 
 * Copyright (c) 2018, 1090273251@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.po.brand;

import com.fh.shop.backend.po.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** 
 * <pre>项目名称：shop_admin_v2     
 * 类名称：Brand    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com     
 * 创建时间：2018年12月27日 下午2:37:30    
 * 修改人：王亚州 2592683566@qq.com      
 * 修改时间：2018年12月27日 下午2:37:30    
 * 修改备注：       
 * @version </pre>    
 */
public class Brand extends Page implements Serializable{
	
	private static final long serialVersionUID = -1232276395145254105L;
	//【id,品牌名，品牌录入时间，品牌修改时间】
	//主键
	private Integer id;
	//品牌名
	private String brandName;

	private  int brandId;
	//添加时间
	private Date  entryTime;
	//修改时间
	private Date  updateTime;

	private String entryTimeStr;

	private String updateTimeStr;
	//最小添加时间按
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minEntryTime;
	//最大添加时间按
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxEntryTime;
	//最小修改时间按
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minUpdateTime;
	//最大修改时间按
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxUpdateTime;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getEntryTimeStr() {
		return entryTimeStr;
	}

	public void setEntryTimeStr(String entryTimeStr) {
		this.entryTimeStr = entryTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	/*************************************/



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getMinEntryTime() {
		return minEntryTime;
	}
	public void setMinEntryTime(Date minEntryTime) {
		this.minEntryTime = minEntryTime;
	}
	public Date getMaxEntryTime() {
		return maxEntryTime;
	}
	public void setMaxEntryTime(Date maxEntryTime) {
		this.maxEntryTime = maxEntryTime;
	}
	public Date getMinUpdateTime() {
		return minUpdateTime;
	}
	public void setMinUpdateTime(Date minUpdateTime) {
		this.minUpdateTime = minUpdateTime;
	}
	public Date getMaxUpdateTime() {
		return maxUpdateTime;
	}
	public void setMaxUpdateTime(Date maxUpdateTime) {
		this.maxUpdateTime = maxUpdateTime;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Brand [id=" + id + ", brandName=" + brandName + ", entryTime=" + entryTime + ", updateTime="
				+ updateTime + ", minEntryTime=" + minEntryTime + ", maxEntryTime=" + maxEntryTime + ", minUpdateTime="
				+ minUpdateTime + ", maxUpdateTime=" + maxUpdateTime + "]";
	}
	
	

}
