
package com.example.wallapop.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public abstract class BaseFragmentActivity extends FragmentActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        addActivity(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        removeActivity(this);
        super.onDestroy();
    }

    protected void addActivity(Activity activity) {
        if (WallapopApplication.getInstance().mActiveActivity != null && activity != null)
            WallapopApplication.getInstance().mActiveActivity.add(activity);
    }

    protected void removeActivity(Activity activity) {
        if (WallapopApplication.getInstance().mActiveActivity != null && activity != null)
            WallapopApplication.getInstance().mActiveActivity.remove(activity);
    }

    @Override
    protected void onUserLeaveHint() {
        Log.d(TAG, "onUserLeaveHint()");
        super.onUserLeaveHint();
    }
}
