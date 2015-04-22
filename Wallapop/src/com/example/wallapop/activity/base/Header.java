
package com.example.wallapop.activity.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.example.wallapop.R;
import com.example.wallapop.utils.ScreenUtil;
import com.example.wallapop.utils.imageloader.core.DisplayImageOptions;
import com.example.wallapop.utils.imageloader.core.ImageLoader;

public final class Header {

    HeaderController mController;

    /** 图片加载参数设置 **/
    private static DisplayImageOptions options;

    protected Header(HeaderController hc) {
        mController = hc;
    }

    public View getView() {
        return mController.mContainer;
    }

    public void setIcon(int resId) {
        ImageView iconView = mController.mIconView;
        if (iconView != null) {
            if (resId > 0) {
                iconView.setImageResource(resId);
            } else {
                iconView.setVisibility(View.GONE);
            }
        }
    }

    public void setIcon(String url) {
        if (mController.mIconView != null) {
            ImageLoader.getInstance().displayImage(url, mController.mIconView, options);
        }
    }

    public void setTitle(String title) {
        if (mController.mTitleView != null) {
            mController.mTitleView.setText(title);
        }
    }

    public void hideHeader() {
        mController.mContainer.setVisibility(View.GONE);
    }

    public void showHeader() {
        mController.mContainer.setVisibility(View.VISIBLE);
    }

    public void setIconMore(boolean visible) {
        ImageView moreView = mController.mIconMore;
        if (moreView != null) {
            moreView.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setBitmapIcon(Bitmap bmIcon) {
        if (mController.mIconView != null) {
            mController.mIconView.setImageBitmap(bmIcon);
        }
    }

    public void setLeftTabIndicator(boolean light) {
        if (mController.mTabsContainer != null) {
            // throw new NullPointerException(
            // "Header has no tab,builder's setCenterTabsView() not called!");
            mController.mLeftTabIndicator.setVisibility(light ? View.VISIBLE : View.GONE);
        }
    }

    public void setRightTabIndicator(boolean light) {
        if (mController.mTabsContainer != null) {
            // throw new NullPointerException(
            // "Header has no tab,builder's setCenterTabsView() not called!");
            mController.mRightTabIndicator.setVisibility(light ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * @param visibility values must be {@link View.VISIBLE},{@link View.GONE}
     *            or {@link View.INVISIBLE}
     */
    public void setRightButtonVisibility(int visibility) {
        if (mController.mRightButton != null) {
            mController.mRightButton.setVisibility(visibility);

            if (visibility == View.VISIBLE) {
                setIconVisibility(false);
            }
        }
    }

    /**
     * @param visibility values must be {@link View.VISIBLE},{@link View.GONE}
     *            or {@link View.INVISIBLE}
     */
    public void setIconVisibility(boolean isVisible) {
        if (mController.mIconView != null) {
            ((View)(mController.mIconView.getParent())).setVisibility(isVisible ? View.VISIBLE
                    : View.INVISIBLE);
            // mController.mIconMore.setVisibility(isVisible ? View.VISIBLE :
            // View.INVISIBLE);
        }
    }

    public TextView getLeftButton() {
        return mController.mLeftButton;
    }

    public TextView getRightButton() {
        return mController.mRightButton;
    }

    public View getBackButton() {
        return mController.mBackView;
    }

    /**
     * @param index 0 or 1
     * @param selected
     */
    public void setTabSelected(int index, boolean selected) {
        if (mController.mTabsContainer != null) {
            if (index == 0) {
                mController.mLeftTabView.setSelected(selected);
                mController.mRightTabView.setSelected(!selected);
            } else if (index == 1) {
                mController.mLeftTabView.setSelected(!selected);
                mController.mRightTabView.setSelected(selected);
            }
        }
    }

    public TextView getTitleView() {
        return mController.mTitleView;
    }

    public View getLeftTabView() {
        return mController.mLeftTabView;
    }

    public View getRightTabView() {
        return mController.mRightTabView;
    }

    public static class Builder {
        HeaderController pHc;

        private Context mContext;

        public Builder(Context context, RelativeLayout container) {
            mContext = context;
            pHc = new HeaderController();
            pHc.mContainer = container;
        }

        public Builder setBackButton(OnClickListener listener) {
            ImageView backView = new ImageView(mContext);
            backView.setImageResource(R.drawable.header_back);
            backView.setOnClickListener(listener);
            int padding = ScreenUtil.dp2px(6);
            backView.setPadding(padding, padding, padding, padding);
            pHc.mBackView = backView;
            return this;
        }

        public Builder setLeftButton(int text, OnClickListener clickListener) {
            String content = mContext.getResources().getString(text);
            TextView btn = new TextView(mContext);
            btn.setBackgroundColor(0x00000000);
            btn.setTextColor(mContext.getResources().getColor(R.color.guide_white));
            btn.setText(content);
//            btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources()
//                    .getDimensionPixelSize(R.dimen.header_title_textsize));
            btn.setGravity(Gravity.CENTER);
            btn.setOnClickListener(clickListener);
            pHc.mLeftButton = btn;
            return this;
        }

        public Builder setRightButton(int text, OnClickListener clickListener) {
            String content = mContext.getResources().getString(text);
            TextView btn = new TextView(mContext);
            btn.setBackgroundColor(0x00000000);
            btn.setTextColor(mContext.getResources().getColor(R.color.guide_white));
            btn.setText(content);
            int pdlr = ScreenUtil.dp2px(6);
            btn.setPadding(pdlr, 0, pdlr, 0);
//            btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,
//                    mContext.getResources().getDimension(R.dimen.header_btn_textsize));
            btn.setGravity(Gravity.CENTER);
            btn.setOnClickListener(clickListener);
            pHc.mRightButton = btn;
            return this;
        }

        public Builder setTitle(int resId) {
            String text = mContext.getResources().getString(resId);
            return setTitle(text);
        }

        public Builder setTitle(String title) {
            TextView titleView = new TextView(mContext);
            titleView.setText(title);
            titleView.setTextColor(mContext.getResources().getColor(R.color.guide_white));
            titleView.setGravity(Gravity.CENTER);
            titleView.setSingleLine(true);
            titleView.setEllipsize(TruncateAt.END);
//            titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
//                    mContext.getResources().getDimension(R.dimen.header_title_textsize));
            pHc.mTitleView = titleView;
            return this;
        }

        public Builder setIcon(int resId, boolean hasmore) {
            return setIcon(resId, hasmore, null);
        }

        public Builder setIcon(int resId, boolean hasmore, OnClickListener listener) {
            Drawable icon = mContext.getResources().getDrawable(resId);
            return setIcon(icon, hasmore, listener);
        }

        public Builder setIcon(Drawable icon, boolean hasmore, OnClickListener listener) {
//            LinearLayout ll = new LinearLayout(mContext);
//            int size = mContext.getResources().getDimensionPixelSize(R.dimen.header_icon_height);
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(size, size);
//            ll.setOrientation(LinearLayout.HORIZONTAL);
//            pHc.mIconView = new CircleTrueImageView(mContext);
//            pHc.mIconView.setImageDrawable(icon);
//            ll.addView(pHc.mIconView, lp);
//
//            ll.setOnClickListener(listener);
//            int pdlr = ScreenUtil.dp2px(3);
//            ll.setPadding(pdlr, 0, pdlr, 0);
//            pHc.mIconMore = new ImageView(mContext);
//            pHc.mIconMore.setImageResource(R.drawable.header_more_point);
//            pHc.mIconMore.setPadding(5, 0, 10, 0);
//            lp = new LinearLayout.LayoutParams(-2, -2);
//            lp.gravity = Gravity.CENTER_VERTICAL;
//            ll.addView(pHc.mIconMore, lp);
//            pHc.mIconMore.setVisibility(hasmore ? View.VISIBLE : View.GONE);
//            // pHc.mIconView = iconView;
//            // pHc.mIconMore = more;
            return this;
        }

//        public Builder setNormalIcon(int iconResId, OnClickListener listener) {
//            LinearLayout ll = new LinearLayout(mContext);
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
//            ll.setOrientation(LinearLayout.HORIZONTAL);
//            pHc.mIconView = new ImageView(mContext);
//            pHc.mIconView.setScaleType(ScaleType.FIT_CENTER);
//            pHc.mIconView.setImageResource(iconResId);
//            ll.addView(pHc.mIconView, lp);
//
//            ll.setOnClickListener(listener);
//            int pdlr = ScreenUtil.dp2px(5);
//            ll.setPadding(pdlr, 0, pdlr, 0);
//            pHc.mIconMore = new ImageView(mContext);
//            pHc.mIconMore.setImageResource(R.drawable.header_more_point);
//            pHc.mIconMore.setPadding(5, 0, 10, 0);
//            lp = new LinearLayout.LayoutParams(-2, -2);
//            lp.gravity = Gravity.CENTER_VERTICAL;
//            ll.addView(pHc.mIconMore, lp);
//            pHc.mIconMore.setVisibility(View.GONE);
//            return this;
//        }

//        @Deprecated
//        public Builder setCenterTabsView(int leftTextResId, int rightTextResId,
//                OnClickListener leftClickLitener, OnClickListener rightClickListener) {
//            View tabsView = View.inflate(mContext, R.layout.header_center_tabs, null);
//
//            pHc.mLeftTabView = tabsView.findViewById(R.id.header_left_tab);
//            pHc.mRightTabView = tabsView.findViewById(R.id.header_right_tab);
//            pHc.mLeftTabIndicator = pHc.mLeftTabView.findViewById(R.id.header_leftab_indicator);
//            pHc.mRightTabIndicator = pHc.mRightTabView.findViewById(R.id.header_rightab_indicator);
//            pHc.mTabsContainer = (ViewGroup)tabsView;
//            pHc.mLeftTabView.setOnClickListener(leftClickLitener);
//            pHc.mRightTabView.setOnClickListener(rightClickListener);
//
//            if (leftTextResId > 0 && rightTextResId > 0) {
//                TextView tabTextView = (TextView)pHc.mLeftTabView
//                        .findViewById(R.id.header_leftab_text);
//                tabTextView.setText(leftTextResId);
//                tabTextView = (TextView)pHc.mRightTabView.findViewById(R.id.header_rightab_text);
//                tabTextView.setText(rightTextResId);
//            }
//            return this;
//        }
//
//        @Deprecated
//        public Builder setCenterTabsTitle(int leftTextResId, int rightTextResId) {
//            if (pHc.mTabsContainer != null) {
//                TextView tabTextView = (TextView)pHc.mLeftTabView
//                        .findViewById(R.id.header_leftab_text);
//                tabTextView.setText(leftTextResId);
//                tabTextView = (TextView)pHc.mRightTabView.findViewById(R.id.header_rightab_text);
//                tabTextView.setText(rightTextResId);
//            }
//            return this;
//        }
//
//        @Deprecated
//        public Builder setCenterTabsTitle(String leftText, String rightText) {
//            if (pHc.mTabsContainer != null) {
//                TextView tabTextView = (TextView)pHc.mLeftTabView
//                        .findViewById(R.id.header_leftab_text);
//                tabTextView.setText(leftText);
//                tabTextView = (TextView)pHc.mRightTabView.findViewById(R.id.header_rightab_text);
//                tabTextView.setText(rightText);
//            }
//            return this;
//        }
//
//        @Deprecated
//        public Builder setLeftTabArrow() {
//            if (pHc.mLeftTabView != null) {
//                ImageView arrowView = new ImageView(mContext);
//                arrowView.setImageResource(R.drawable.header_icon_arrow);
//                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
//                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                lp.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
//                lp.rightMargin = ScreenUtil.dp2px(6);
//                ((FrameLayout)pHc.mLeftTabView).addView(arrowView, lp);
//
//            }
//            return this;
//        }

        public void setIcon(String url) {
            ImageLoader.getInstance().displayImage(url, pHc.mIconView, options);
        }

        private Options getOptions() {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Bitmap.Config.RGB_565;
            opt.inPurgeable = true;
            opt.inInputShareable = true;
            return opt;
        }

        public Header build() {
            Header header = new Header(pHc);
            pHc.apply();
//            options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
//                    .showImageOnLoading(R.drawable.default_icon162)
//                    .showImageForEmptyUri(R.drawable.default_icon162)
//                    .showImageOnFail(R.drawable.default_icon162)
//                    .showImageOnLoading(R.drawable.default_icon162).decodingOptions(getOptions())
//                    .bitmapConfig(Bitmap.Config.RGB_565).build();

            return header;
        }
    }

    private static class HeaderController {

        private RelativeLayout mContainer;

        private ViewGroup mTabsContainer;

        private View mLeftTabView;

        private View mRightTabView;

        private View mLeftTabIndicator;

        private View mRightTabIndicator;

        private ImageView mIconView;

        private ImageView mIconMore;

        private TextView mTitleView;

        private ImageView mBackView;

        private TextView mLeftButton;

        private TextView mRightButton;

        HeaderController() {
        }

        void apply() {

            LayoutParams lp = null;
            if (mBackView != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                mContainer.addView(mBackView, lp);
            }
            if (mTabsContainer != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                mContainer.addView(mTabsContainer, lp);
            }

            if (mTitleView != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                int lrmargin = ScreenUtil.dp2px(50);
                lp.leftMargin = lrmargin;
                lp.rightMargin = lrmargin;
                mContainer.addView(mTitleView, lp);
            }

            if (mIconView != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                mContainer.addView((View)mIconView.getParent(), lp);
            }

            if (mLeftButton != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                lp.leftMargin = 15;
                mContainer.addView(mLeftButton, lp);
            }

            if (mRightButton != null) {
                lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                mContainer.addView(mRightButton, lp);
            }

        }
    }

}
