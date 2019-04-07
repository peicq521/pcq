package com.fh.shop.backend.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {
    private static final long serialVersionUID = 8481593600017762864L;
    private Integer id;
    //商品名称
    private String productName;
    //商品价格
    private Double productPrice;

    private String productImagePath;

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

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }
}
