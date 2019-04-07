package com.fh.shop.backend.po.product;

import com.fh.shop.backend.po.Page;
import com.fh.shop.backend.po.brand.Brand;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Product extends Page implements Serializable {

	private static final long serialVersionUID = -1899653511936817284L;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//主键
	private Integer id;
	//商品名称
	private String productName;
	//商品价格
	private Double productPrice;
	//添加时间
	private Date entryTime;
	//修改时间
	private Date updateTime;
	//最小价格
	private Double minPrice;
	//最大价格
	private Double maxPrice;

	private  String imagePaths;

	//最小添加时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minEntryTime;
	//最大添加时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxEntryTime;
	//最小修改时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH")
	private Date minUpdateTime;
	//最大修改时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH")
	private Date maxUpdateTime;
	//品牌 
	private Brand brand = new Brand();
	//排序
	private Integer reorder;

	private String productImagePath;

	private String entryTimeStr;

	private String updateTimeStr;

	private String ids;

	private String oldId;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	/*******************GET AND SET***************************/


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
	public String getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(String imagePaths) {
		this.imagePaths = imagePaths;
	}
	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
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
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Integer getReorder() {
		return reorder;
	}
	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + ", entryTime="
				+ entryTime + ", updateTime=" + updateTime + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", minEntryTime=" + minEntryTime + ", maxEntryTime=" + maxEntryTime + ", minUpdateTime="
				+ minUpdateTime + ", maxUpdateTime=" + maxUpdateTime + ", brand=" + brand + ", reorder=" + reorder
				+ "]";
	}
	
	
	
	
	
	
	

}
