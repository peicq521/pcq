/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:IBrandService.java 
 * 包名:com.fh.shop.backend.biz.brand 
 * 创建日期:2018年12月27日下午11:41:03 
 * Copyright (c) 2018, 1090273251@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.biz.brand;

import com.fh.shop.backend.po.brand.Brand;

import java.util.List;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：IBrandService    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2018年12月27日 下午11:41:03    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2018年12月27日 下午11:41:03    
 * 修改备注：       
 * @version </pre>    
 */
public interface IBrandService {

	/** <pre>addBrand(添加品牌)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:41:47    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:41:47    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void addBrand(Brand brand);

	/** <pre>queryBrandPage(当前页信息)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:42:41    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:42:41    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public List<Brand> queryBrandPage(Brand brand);

	/** <pre>queryCount(总条数)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:44:11    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:44:11    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public Long queryCount(Brand brand);

	/** <pre>findBrand(回显)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:49:49    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:49:49    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public Brand findBrand(Integer id);

	/** <pre>updateBrand(修改品牌)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:52:52    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:52:52    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void updateBrand(Brand brand);

	/** <pre>deleteBrand(单条删除)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:53:59    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:53:59    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteBrand(Integer id);

	/** <pre>deleteBechBrand(批量删除)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月27日 下午11:55:33    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月27日 下午11:55:33    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	public void deleteBechBrand(String ids);

	/** <pre>queryBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月29日 下午2:33:41    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月29日 下午2:33:41    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Brand> queryBrand();

}
