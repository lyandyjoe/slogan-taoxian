
package com.example.wallapop.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.example.wallapop.R;

public abstract class BaseFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    protected Header mHeader;

    private View mDivideLine;

    protected View mContentView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.base_title_layout, container, false);
        RelativeLayout headerContainer = (RelativeLayout)rootView.findViewById(R.id.header_container);
        mDivideLine = rootView.findViewById(R.id.main_layout_divider);
        mHeader = onCreateHeader(headerContainer);

        mContentView = onCreateContentView();

        if (mContentView != null) {
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
            lp.weight = 1;
            ((LinearLayout)rootView).addView(mContentView, lp);
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    protected void onShow() {
        
    }

    public void onUserLeaveHint() {

    }

    protected void onNewIntent(Intent it) {

    }

    /**
     * 自定义标头
     * 
     * @param container
     * @return
     */
    protected abstract Header onCreateHeader(RelativeLayout container);

    protected abstract View onCreateContentView();

    public void setHeaderVisibility(int visible) {
        mHeader.getView().setVisibility(visible);
        mDivideLine.setVisibility(visible);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        onShow();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        mContentView = null;
        mHeader = null;
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
