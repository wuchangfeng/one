package com.wu.allen.myone.ui.activity;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.ui.fragment.BookFragment;
import com.wu.allen.myone.ui.fragment.OneImgFragment;
import com.wu.allen.myone.ui.fragment.QaFragment;
import com.wu.allen.myone.ui.fragment.SuJinFragment;
import com.wu.allen.myone.utils.NetWorkUtil;
import com.wu.allen.myone.utils.ToastUtil;

import static com.wu.allen.myone.R.id.toolbar;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIntent();
        initView();
        switchToFragmnent();
    }


    public void initIntent(){
        if(!NetWorkUtil.isNetworkConnected(this)||
            !NetWorkUtil.isWifiConnected(this)){
            SnackbarManager.show(
                Snackbar.with(getApplicationContext())
                    .text(getString(R.string.no_net))
                    .actionLabel(getString(R.string.go_save))
                    .actionColor(Color.RED)
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {
                            startActivity(new Intent(MainActivity.this, SaveArtActivity.class));
                        }
                    })
                , this);
        }
    }


    public void initView(){
        mToolbar = $(toolbar);
        mTabLayout = $(R.id.tab_layout);
        mToolbar.setTitle(" ");
        mToolbar.inflateMenu(R.menu.menu_toolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    ToastUtil.showShort(MainActivity.this,"next version");
                    //ToastUtil.showLong(MainActivity.this,getResources().getString(R.string.search_undone));
                }else if(menuItemId == R.id.action_save){
                    startActivity(new Intent(MainActivity.this,SaveArtActivity.class));
                }else if(menuItemId == R.id.action_setting){
                    ToastUtil.showShort(MainActivity.this,"next version");
                    //startActivity(new Intent(MainActivity.this,SettingActivity.class));
                }else if(menuItemId == R.id.action_about){
                    startActivity(new Intent(MainActivity.this,AboutActivity.class));
                }
                return true;
            }
        });
    }


    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }


    public void switchToFragmnent() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new OneImgFragment();
                    case 1:
                        return new SuJinFragment();
                    case 2:
                        return new QaFragment();
                    case 3:
                        return new BookFragment();
                    default:
                        return new OneImgFragment();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.OneImg);
                    case 1:
                        return getString(R.string.SuJin);
                    case 2:
                        return getString(R.string.WenDa);
                    case 3:
                        return getString(R.string.TuShu);
                    default:
                        return getString(R.string.OneImg);
                }
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
