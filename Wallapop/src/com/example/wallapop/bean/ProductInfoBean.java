
package com.example.wallapop.bean;

import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.wallapop.bean.base.BaseBean;

/**
 * 商品信息
 * 
 * @author york
 */
public class ProductInfoBean extends BaseBean<ProductInfoBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 图片URl
     */
    private String[] productImageUrls;

    /**
     * 商品缩略图
     */
    private String productThumbImage;

    public String[] getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(String[] productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    public String getProductThumbImage() {
        return productThumbImage;
    }

    public void setProductThumbImage(String productThumbImage) {
        this.productThumbImage = productThumbImage;
    }

    /**
     * 商品价格
     */
    private double productPrice;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 是否是新商品
     */
    private boolean isNewProduct;

    @Override
    public ProductInfoBean parseJSON(JSONObject jsonObj) {
        return null;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public ProductInfoBean cursorToBean(Cursor cursor) {
        return null;
    }

    @Override
    public ContentValues beanToValues() {
        return null;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isNewProduct() {
        return isNewProduct;
    }

    public void setNewProduct(boolean isNewProduct) {
        this.isNewProduct = isNewProduct;
    }

}
