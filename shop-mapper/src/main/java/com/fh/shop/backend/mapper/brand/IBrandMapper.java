/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:IBrandMapper.java 
 * 包名:com.fh.shop.backend.mapper.brand 
 * 创建日期:2018年12月27日下午11:58:48 
 * Copyright (c) 2018, 2592683566@qq.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.mapper.brand;

import com.fh.shop.backend.po.brand.Brand;

import java.util.List;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：IBrandMapper    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com     
 * 创建时间：2018年12月27日 下午11:58:48    
 * 修改人：王亚州 2592683566@qq.com      
 * 修改时间：2018年12月27日 下午11:58:48    
 * 修改备注：       
 * @version </pre>    
 */
	public interface IBrandMapper {

	/** <pre>addBrand(添加)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月27日 下午11:59:48    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月27日 下午11:59:48    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void addBrand(Brand brand);

	/** <pre>queryBrandPage(分页信息)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:00:49    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:00:49    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public List<Brand> queryBrandPage(Brand brand);

	/** <pre>queryCount(总条数)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:01:28    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:01:28    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public Long queryCount(Brand brand);

	/** <pre>findBrand(回显)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:02:23    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:02:23    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public Brand findBrand(Integer id);

	/** <pre>updateBrand(修改品牌)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:02:56    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:02:56    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void updateBrand(Brand brand);

	/** <pre>deleteBrand(单条删除)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:04:23    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:04:23    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteBrand(Integer id);

	/** <pre>deleteBechBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月28日 上午12:08:00    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月28日 上午12:08:00    
	 * 修改备注： 
	 * @param idList</pre>    
	 */
	public void deleteBechBrand(List<Integer> idList);

	/** <pre>queryBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月29日 下午2:34:32    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月29日 下午2:34:32    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Brand> queryBrand();

}
