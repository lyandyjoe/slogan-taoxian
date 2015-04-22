
package com.example.wallapop.activity.base;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

import com.example.wallapop.utils.Constants;
import com.example.wallapop.utils.imageloader.core.ImageLoader;
import com.example.wallapop.utils.imageloader.core.ImageLoaderConfiguration;

/**
 * Created by york on 15/4/17.
 */
public class WallapopApplication extends Application {
    /**
     * 活动的activity
     */
    public List<Activity> mActiveActivity = new LinkedList<Activity>();

    private volatile static WallapopApplication instance;

    public synchronized static WallapopApplication getInstance() {
        if (instance == null) {
            synchronized (WallapopApplication.class) {
                if (instance == null) {
                    instance = new WallapopApplication();
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        File cacheDir = new File(Constants.dir_appcache);
        // ImageLoaderConfiguration config = new
        // ImageLoaderConfiguration.Builder(
        // getApplicationContext()).threadPoolSize(THREAD_POOL_MAX)
        // .threadPriority(Thread.NORM_PRIORITY - 2)
        // .memoryCache(new UsingFreqLimitedMemoryCache(MEMORY_CACHE_SIZE_MAX))
        // .memoryCacheExtraOptions(MAX_IMG_W_FOR_MEMORY_CACHE,
        // MAX_IMG_H_FOR_MEMORY_CACHE)
        // .denyCacheImageMultipleSizesInMemory().diskCache(new
        // UnlimitedDiskCache(cacheDir))
        // // .diskCacheFileNameGenerator(new Md5FileNameGenerator())
        // // .enableLogging() // Not necessary in common
        // // .offOutOfMemoryHandling()
        // // .memoryCache(new WeakMemoryCache())
        // .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        // ImageLoader.getInstance().init(config);
    }

    // add Activity
    public void addActivity(Activity activity) {
        mActiveActivity.add(activity);
    }

    public void exit() {
        try {
            for (Activity activity : mActiveActivity) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}
