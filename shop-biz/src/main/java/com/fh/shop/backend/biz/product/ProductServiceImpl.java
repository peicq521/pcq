package com.fh.shop.backend.biz.product;

import com.alibaba.dubbo.common.utils.StringUtils;

import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.mapper.product.IProductMapper;
import com.fh.shop.backend.po.ImageInfo;
import com.fh.shop.backend.po.product.Product;

import com.fh.shop.backend.vo.ProductVo;
import com.fh.util.DateUtil;
import com.fh.util.FileUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("productService")
public class ProductServiceImpl implements IProductService{
	
	public Date getNowDate(){
		
		Date now = new Date();
		
		return now;
	}
	
	@Resource
	private IProductMapper productMapper;


	public void addProduct(Product product) {

		//addImg(product, fileInfo, rootPath);

		Date date = new Date();

		product.setEntryTime(date);

		product.setUpdateTime(date);

		product.setProductImagePath(product.getProductImagePath().substring(1));

		productMapper.addProduct(product);

		//addSonImg(product, fileInfoList, rootPath);

		List<ImageInfo> list = new ArrayList<>();

		String imgPaths = product.getImagePaths();

		System.out.println(imgPaths);

		if (imgPaths.length() > 1) {

			String[] split = imgPaths.substring(1).split(",");

			for (String path : split) {

				ImageInfo productImage = new ImageInfo();

				productImage.setProductId(product.getId());

				productImage.setImagePath(path);

				list.add(productImage);
			}

			productMapper.addProductChildImage(list);
		}
	}

	private void deleteTomcatImg(String rootPath, String imgPath) {

		if (StringUtils.isNotEmpty(imgPath)) {

			String oldPath = rootPath + imgPath;

			FileUtil.deleteFile(oldPath);
		}
	}
	private void deleteSonImg(Product product, String rootPath) {

		String oldId = product.getOldId();

		String oldPath = product.getProductImagePath();

		if (StringUtils.isNotEmpty(oldId) && StringUtils.isNotEmpty(oldPath)) {

			List<Integer> oldIdList = new ArrayList<Integer>();

			String[] split = oldId.split(",");

			for (int i = 0; i < split.length; i++) {

				oldIdList.add(Integer.valueOf(split[i]));
			}

			productMapper.deleteImage(oldIdList);

			String[] path = oldPath.split(",");

			for (int i = 0; i < path.length; i++) {

				deleteTomcatImg(rootPath, path[i]);
			}
		}
	}
	public List<Product> selectList() {

		List<Product> selectList = productMapper.selectList();

		return selectList;
	}
	public DataTableInfo buildDataTable(Product product, Integer start, Integer length, Integer draw, String orderDir, String beanName) {
		//排序信息
		buildOrderInfo(product, orderDir, beanName);
		Map<Object, Object> resultMap = new HashMap<>();
		//总条数 分页信息
		Long count = queryCount(product);
		product.setStartPos(start);
		product.setPageSize(length);
		//当前页信息
		List<Product> list = queryProductPage(product);
		converDate(list);
		DataTableInfo dataTableInfo = DataTableInfo.buildDataTable(draw, count, count, list);
		return  dataTableInfo;
	}

    @Override
    public List<ProductVo> findProductList() {
        List<ProductVo> list = new ArrayList<>();
		List<Product> productVoList =	productMapper.findProductList();
		for (Product productVo : productVoList) {
			ProductVo productVo1 = new ProductVo();
			productVo1.setId(productVo.getId());
			productVo1.setProductName(productVo.getProductName());
			productVo1.setProductImagePath(productVo.getProductImagePath());
			productVo1.setProductPrice(productVo.getProductPrice());
			list.add(productVo1);
		}
		return list;
    }

    private void buildOrderInfo(Product product, String orderDir, String beanName) {
		product.setSortField(beanName);
		product.setSort(orderDir);
		if (product.getSortField().equals("productPrice")) {
			product.setSortField("price");
		}
		if (product.getSortField().equals("entryTimeStr")) {
			product.setSortField("entryTime");
		}
		if (product.getSortField().equals("updateTimeStr")) {
			product.setSortField("updateTime");
		}
	}

	private void converDate(List<Product> list) {
		for (Product shop : list) {
			shop.setEntryTimeStr(DateUtil.date2Str(shop.getEntryTime(), DateUtil.L_M_D_H_M_S));
			shop.setUpdateTimeStr(DateUtil.date2Str(shop.getUpdateTime(), DateUtil.L_M_D_H_M_S));
		}
	}

	public void deleteProduct(Integer id) {
		productMapper.deleteProduct(id);
	}

	public Product selectProduct(Integer id) {

		Product selectProduct = productMapper.selectProduct(id);

		return selectProduct;
	}

	public void updateProduct(Product product, String rootPath) {

		//updateImg(product, fileInfo, rootPath);

		deleteSonImg(product, rootPath);

		//addSonImg(product, fileInfoList, rootPath);

		product.setUpdateTime(new Date());

		productMapper.updateProduct(product);

		List<ImageInfo> list = new ArrayList<>();

		String imgPaths = product.getImagePaths();

		if (imgPaths.length() > 1) {

			String[] split = imgPaths.substring(1).split(",");

			for (String path : split) {

				ImageInfo productImage = new ImageInfo();

				productImage.setProductId(product.getId());

				productImage.setImagePath(path);

				list.add(productImage);
			}

			productMapper.addProductChildImage(list);
		}
	}




	public void deleteBatchProduct(String ids) {
		String[] idsList = ids.split(",");

		List<Integer> idList = new  ArrayList<Integer>();

		for (String id : idsList) {

			idList.add(Integer.valueOf(id));
		}

		productMapper.deleteBatchProduct(idList);
	}

	public Long queryCount(Product product) {

		Long quweyCount = productMapper.queryCount(product);

		return quweyCount;
	}

	public List<Product> queryProductPage(Product product) {
		return productMapper.queryProductPage(product);
	}

	public List<Product> productExcel(Product product) {

		List<Product> importValue = productMapper.productExcel(product);

		return importValue;
	}


	public List<ImageInfo> childImage(Product product) {

		return productMapper.childImage(product);
	}



}
