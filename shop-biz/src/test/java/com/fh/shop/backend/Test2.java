package com.fh.shop.backend;

import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.vo.ProductVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.biz.xml"})
public class Test2 extends AbstractJUnit4SpringContextTests {
    @Resource(name = "productService")
    private IProductService productService;
    @Test
    public void test(){
        List<ProductVo> productList = productService.findProductList();
        System.out.println(productList);
    }
}
