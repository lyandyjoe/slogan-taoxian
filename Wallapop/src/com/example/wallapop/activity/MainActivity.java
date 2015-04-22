
package com.example.wallapop.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.wallapop.R;
import com.example.wallapop.activity.base.BaseFragmentActivity;
import com.example.wallapop.adapter.SlideMenuAdapter;
import com.example.wallapop.fragment.HomeFragment;
import com.example.wallapop.view.ActionBarDrawerToggle;
import com.example.wallapop.view.DrawerArrowDrawable;

public class MainActivity extends BaseFragmentActivity implements OnItemClickListener {
    RelativeLayout rl;

    private DrawerLayout mDrawerLayout;

    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerArrowDrawable drawerArrow;

    public static FragmentManager fm;

    private boolean drawerMenuOpenOrClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

        fm = this.getSupportFragmentManager();
        initView(fm);

        rl = (RelativeLayout)findViewById(R.id.rl);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navdrawer);

        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, drawerArrow,
                R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                drawerMenuOpenOrClose = false;
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                drawerMenuOpenOrClose = true;
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        SlideMenuAdapter slideMenuAdapter = new SlideMenuAdapter(this);
        mDrawerList.setAdapter(slideMenuAdapter);
        mDrawerList.setOnItemClickListener(this);
    }

    public void initView(FragmentManager fragmentManager) {
        initFragment(new HomeFragment());
    }

    // 切換Fragment
    public void changeFragment(Fragment f) {
        changeFragment(f, false);
    }

    // 初始化Fragment(FragmentActivity中呼叫)
    public void initFragment(Fragment f) {
        changeFragment(f, true);
    }

    private void changeFragment(Fragment f, boolean init) {
        FragmentTransaction ft = fm.beginTransaction().setCustomAnimations(
                R.anim.umeng_fb_slide_in_from_left, R.anim.umeng_fb_slide_out_from_left,
                R.anim.umeng_fb_slide_in_from_right, R.anim.umeng_fb_slide_out_from_right);
        ;
        ft.replace(R.id.content_frame, f);
        if (!init)
            ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(rl)) {
                mDrawerLayout.closeDrawer(rl);
                drawerMenuOpenOrClose = false;
            } else {
                mDrawerLayout.openDrawer(rl);
                drawerMenuOpenOrClose = true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (drawerMenuOpenOrClose == false) {
                // return mDoubleClickExitHelper.onKeyDown(keyCode, event);
            } else {
                mDrawerLayout.closeDrawers();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        mDrawerLayout.closeDrawers();
        drawerMenuOpenOrClose = false;
    }
}
