package com.fh.shop.backend.mapper.product;

import com.fh.shop.backend.po.ImageInfo;
import com.fh.shop.backend.po.product.Product;

import java.util.List;

/**
 * 
 * <pre>项目名称：shop_admin_v2     
 * 类名称：IProductMapper    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com     
 * 创建时间：2018年12月24日 下午2:13:37    
 * 修改人：王亚州 2592683566@qq.com      
 * 修改时间：2018年12月24日 下午2:13:37    
 * 修改备注：       
 * @version </pre>
 */
public interface IProductMapper {
	/** <pre>addProduct(添加商品)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月24日 下午2:14:06    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月24日 下午2:14:06    
	 * 修改备注： 
	 * @param product</pre>
	 */
	public void addProduct(Product product);
	/**<pre>selectList(查询)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月25日 下午2:08:21    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月25日 下午2:08:21    
	 * 修改备注： 
	 * @return</pre>
	 */
	public List<Product> selectList();
	/**<pre>deleteProduct(删除商品)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月25日 下午2:45:32    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月25日 下午2:45:32    
	 * 修改备注： 
	 * @param id</pre>
	 */
	public void deleteProduct(Integer id);
	/** <pre>updateProduct(回显商品)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月25日 下午3:05:34    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月25日 下午3:05:34    
	 * 修改备注： 
	 * @param id
	 * @return</pre>
	 */
	public Product selectProduct(Integer id);
	/** <pre>updateProduct(修改商品)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月25日 下午3:40:58    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月25日 下午3:40:58    
	 * 修改备注： 
	 * @param product</pre>
	 */
	public void updateProduct(Product product);
	/** <pre>deleteBatchProduct(批量删除)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月25日 下午9:30:44    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月25日 下午9:30:44    
	 * 修改备注： 
	 * @param idList</pre>
	 */
	public void deleteBatchProduct(List<Integer> idList);
	/** <pre>quweyCount(查询总条数)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月26日 下午6:48:05    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月26日 下午6:48:05    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public Long queryCount(Product product);
	/** <pre>queryProductPage(数据列表)   
	 * 创建人：王亚州 2592683566@qq.com     
	 * 创建时间：2018年12月26日 下午7:01:52    
	 * 修改人：王亚州 2592683566@qq.com      
	 * 修改时间：2018年12月26日 下午7:01:52    
	 * 修改备注： 
	 * @param product
	 * @return</pre>    
	 */
	public List<Product> queryProductPage(Product product);

	public List<Product> productExcel(Product product);

	public void addProductChildImage(List<ImageInfo> list);

	public List<ImageInfo> childImage(Product product);

	public void deleteImage(List<Integer> list);

    List<Product> findProductList();

    void addBatchImage(List<ImageInfo> imgFileList);

}
