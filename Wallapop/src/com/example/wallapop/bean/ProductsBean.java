
package com.example.wallapop.bean;

import java.util.List;

import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.wallapop.bean.base.BaseBean;

/**
 * 商品列表
 * 
 * @author york
 */
public class ProductsBean extends BaseBean<ProductsBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品列表
     */
    private List<ProductInfoBean> productsList;

    @Override
    public ProductsBean parseJSON(JSONObject jsonObj) {
        return null;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public ProductsBean cursorToBean(Cursor cursor) {
        return null;
    }

    @Override
    public ContentValues beanToValues() {
        return null;
    }

    public List<ProductInfoBean> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductInfoBean> productsList) {
        this.productsList = productsList;
    }

}
