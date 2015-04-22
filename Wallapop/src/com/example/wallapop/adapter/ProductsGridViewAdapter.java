
package com.example.wallapop.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wallapop.R;
import com.example.wallapop.bean.ProductInfoBean;
import com.example.wallapop.utils.imageloader.core.ImageLoader;
import com.example.wallapop.view.ShapeImageView;

public class ProductsGridViewAdapter extends BaseAdapter {
    List<ProductInfoBean> productsList;

    private Context mContext;

    public ProductsGridViewAdapter(Context context,List<ProductInfoBean> productsList) {
        this.mContext = context;
        this.productsList = productsList;
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.product_item_layout, null);
            viewHolder.product_image = (ShapeImageView)convertView.findViewById(R.id.product_image);
            viewHolder.product_price = (TextView)convertView.findViewById(R.id.product_price);
            viewHolder.product_name = (TextView)convertView.findViewById(R.id.product_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 设置数据
        if (productsList.get(position).getProductThumbImage() != null) {
            ImageLoader.getInstance().displayImage(
                    productsList.get(position).getProductThumbImage(), viewHolder.product_image);
        } else {
            viewHolder.product_image.setImageResource(R.drawable.a);
        }
        viewHolder.product_price.setText(productsList.get(position).getProductPrice() + " "
                + mContext.getResources().getString(R.string.rmb));
        viewHolder.product_name.setText(productsList.get(position).getProductName());
        return convertView;
    }

    class ViewHolder {
        ShapeImageView product_image;

        TextView product_price;

        TextView product_name;
    }
}
