
package com.example.wallapop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.wallapop.R;

public class ScreenUtil {
    private static final String TAG = ScreenUtil.class.getSimpleName();
    
    // 目标模糊半径
    public static final float GBLUR_RADIUS_DEST = 220;
    
    // 屏幕宽
    public static int widthPixels;
    
    // 屏幕高
    public static int heightPixels;
    
    // 屏幕密度
    public static float density;
    
    public static Context mAppContext;
    
    // 图片在沟通中显示最大宽度
    public static int maxImageWidth;
    
    // 图片在沟通中显示最小宽度
    public static int minImageWidth;
    
    // 图片在沟通中显示最大高度
    public static int maxImageHeight;
    
    // 图片在沟通中显示最小高度
    public static int minImageHeight;
    
    public static void init(Context context) {
        mAppContext = context;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        widthPixels = dm.widthPixels;
        heightPixels = dm.heightPixels;
        density = dm.density;
        
        maxImageWidth = widthPixels / 2;
        minImageWidth = widthPixels / 4;
        maxImageHeight = heightPixels / 3;
        minImageHeight = heightPixels / 8;
    }
    
    private static void throwNotInitException() {
        throw new IllegalStateException("ScreenUtil is not init in Application");
    }
    
    /**
     * dp转px
     * 
     * @param dpValue dp
     * @return int px
     * @throws
     */
    public static int dp2px(float dpValue) {
        if (mAppContext == null) {
            throwNotInitException();
        }
        return (int)(dpValue * density + 0.5f);
    }
    
    /**
     * px 转 dp
     * 
     * @param pxValue px
     * @return int dp
     * @throws
     */
    public static int px2dp(float pxValue) {
        if (mAppContext == null) {
            throwNotInitException();
        }
        return (int)(pxValue / density + 0.5f);
    }
    
    /**
     * 获取状态栏高度
     * 
     * @return int
     * @throws
     */
    public static int getStatusBarHeight() {
        return Resources.getSystem().getDimensionPixelSize(
                Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
    
    /**
     * 获取指定高度的屏幕截图
     * 
     * @return Bitmap
     * @throws
     */
//    public static Bitmap getScreenShotForPopWin(Activity activity, int popWindowH) {
//        if (mAppContext == null) {
//            throwNotInitException();
//        }
//        int statusBarH = getStatusBarHeight();
//        int headerH = (int)activity.getResources().getDimension(R.dimen.header_height);
//        
//        int startX = 0;
//        int startY = statusBarH + headerH;
//        
//        int width = widthPixels;
//        int height = popWindowH;
//        
//        Bitmap dest = getScreenShot(activity, startX, startY, width, height);
//        
//        // test fuc
//        // savePic(dest, "sdcard/xx.png");
//        return dest;
//    }
    
//    public static Bitmap getScreenShot(Activity activity, int x, int y, int width, int height) {
//        View view = activity.getWindow().getDecorView();
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
//        Bitmap src = view.getDrawingCache();
//        
//        Bitmap dest = null;
//        float scale = GBlurUtil.GBLUR_RADIUS_ORIGIN / GBLUR_RADIUS_DEST;
//        
//        if (scale < 1) {
//            Matrix matrix = new Matrix();
//            matrix.postScale(scale, scale);
//            dest = Bitmap.createBitmap(src, x, y, width, height, matrix, true);
//        } else {
//            dest = Bitmap.createBitmap(src, x, y, width, height);
//        }
//        
//        view.destroyDrawingCache();
//        
//        return dest;
//    }
    
//    /**
//     * 获取封装popWindow高度
//     * 
//     * @param Count
//     * @param showtyPe
//     * @return
//     */
//    public static int getMainPopHeight(int Count, int showtyPe) {
//        if (mAppContext == null) {
//            throwNotInitException();
//        }
//        
//        int viewPagerH = (int)mAppContext.getResources().getDimension(
//                R.dimen.main_pop_viewPager_height);
//        int tableH = (int)mAppContext.getResources()
//                .getDimension(R.dimen.main_pop_tableview_height);
//        int lineCount = 0;
//        int i = Count / 4;
//        int a = Count % 4;
//        if (a == 0) {
//            lineCount = i;
//        } else {
//            lineCount = i + 1;
//        }
//        if (showtyPe == 1 || showtyPe == 0) {
//            return viewPagerH;
//        } else if (showtyPe == 2) {
//            return lineCount * tableH;
//        } else if (showtyPe == 3) {
//            return viewPagerH + lineCount * tableH;
//        }
//        return 0;
//    }
    
    /**
     * 根据屏幕的高度计算相应的视图高度
     * 
     * @param high
     * @return
     */
    public static int getViewHeight(int high) {
        return high * heightPixels / 1920;
    }
    
    /**
     * 根据屏幕的高度计算相应的视图高度
     * 
     * @param width
     * @return
     */
    public static int getViewWidth(int width) {
        return width * widthPixels / 1080;
    }
    
    public static int[] getScreenInfo(Context mContext) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = mContext.getResources().getDisplayMetrics();
        int info[] = {
                dm.widthPixels, dm.heightPixels
        };
        return info;
    }
    
    /**
     * �������뷨
     */
    public static void dismissKeyBoard(Activity context) {
        View view = context.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager)context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
}
