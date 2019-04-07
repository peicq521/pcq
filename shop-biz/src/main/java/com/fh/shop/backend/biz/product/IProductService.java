package com.fh.shop.backend.biz.product;


import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.po.ImageInfo;
import com.fh.shop.backend.po.product.Product;
import com.fh.shop.backend.vo.ProductVo;

import java.util.List;

public interface IProductService {
	/**
	 * <pre>addProduct(添加商品)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2018年12月23日 下午8:11:20    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月23日 下午8:11:20    
	 * 修改备注： 
	 * @param product</pre>
	 */
	public void addProduct(Product product);
	/**
	 * <pre>selectList(查询)   
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月25日 下午2:07:29    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2018年12月25日 下午2:07:29    
	 * 修改备注： 
	 * @return</pre>
	 */
	public List<Product> selectList();
	/**
	 * <pre>deleteProduct(删除商品)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月25日 下午2:44:26
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月25日 下午2:44:26
	 * 修改备注：
	 * @param id</pre>
	 */
	public void deleteProduct(Integer id);
	/**
	 * <pre>updateProduct(商品回显)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月25日 下午3:03:43
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月25日 下午3:03:43
	 * 修改备注：
	 * @return</pre>
	 */
	public Product selectProduct(Integer id);
	/**
	 * <pre>updateProduct(商品修改)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月25日 下午3:39:52
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月25日 下午3:39:52
	 * 修改备注：
	 * @param product</pre>
	 */
	void updateProduct(Product product, String realPath);
	/**
	 * <pre>deleteBatchProduct(批量删除)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月25日 下午9:26:11
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月25日 下午9:26:11
	 * 修改备注：
	 * @param ids</pre>
	 */
	public void deleteBatchProduct(String ids);
	/** <pre>quweyCount(查询总条数)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月26日 下午6:45:48
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月26日 下午6:45:48
	 * 修改备注：
	 * @return</pre>
	 */
	public Long queryCount(Product product);
	/** <pre>queryProductPage(数据列表)
	 * 创建人：王亚州 2592683566@qq.com
	 * 创建时间：2018年12月26日 下午7:00:55
	 * 修改人：王亚州 2592683566@qq.com
	 * 修改时间：2018年12月26日 下午7:00:55
	 * 修改备注：
	 * @param product
	 * @return</pre>
	 */
	 List<Product> queryProductPage(Product product);


	 List<Product> productExcel(Product product);

	List<ImageInfo> childImage(Product product);


	DataTableInfo buildDataTable(Product product, Integer start, Integer length, Integer draw, String orderDir, String beanName);

    List<ProductVo> findProductList();
}
