package com.fh.shop.backend.po;

import java.io.Serializable;

public class ImageInfo implements Serializable {

    private static final long serialVersionUID = -2092563667812091579L;
    private  long id;
    private  String imagePath;
    private long  productId;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
