
package com.example.wallapop.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.wallapop.R;
import com.example.wallapop.adapter.ProductsGridViewAdapter;
import com.example.wallapop.bean.ProductInfoBean;
import com.example.wallapop.view.StaggeredGridView;

public class HomeFragment extends Fragment implements OnScrollListener, OnItemClickListener {

    StaggeredGridView mProductGridView;

    ProductsGridViewAdapter pGridViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateData();
        mProductGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        pGridViewAdapter = new ProductsGridViewAdapter(getActivity(), productsList);

        mProductGridView.setAdapter(pGridViewAdapter);

        mProductGridView.setOnScrollListener(this);
        mProductGridView.setOnItemClickListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
    };

    /**
     * 
     */
    List<ProductInfoBean> productsList;

    private void generateData() {
        productsList = new ArrayList<ProductInfoBean>();
        for (int i = 0; i < 12; i++) {
            ProductInfoBean productInfo = new ProductInfoBean();
            productInfo.setProductName("product" + i);
            productInfo.setProductPrice(i);
            productInfo
                    .setProductThumbImage("http://upload-images.jianshu.io/upload_images/70863-60f3e437e600b926.png");
            productInfo.setNewProduct(true);
            productInfo.setProductDescription("ProductDescription");
            productsList.add(productInfo);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {

    }
}
