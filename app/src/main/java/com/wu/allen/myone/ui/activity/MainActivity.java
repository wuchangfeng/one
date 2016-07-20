package com.wu.allen.myone.ui.activity;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.ui.fragment.OneImgFragment;
import com.wu.allen.myone.ui.fragment.QaFragment;
import com.wu.allen.myone.ui.fragment.SuJinFragment;
import com.wu.allen.myone.utils.NetWorkUtil;
import com.wu.allen.myone.utils.ToastUtil;
import java.util.List;

import static com.wu.allen.myone.R.id.toolbar;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private Toolbar mToolbar;
    private ViewPager viewPager;
    private List<Fragment> fragments;

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
            // TODO: 2016/7/16
            SnackbarManager.show(
                Snackbar.with(getApplicationContext())
                    .text(getString(R.string.no_net))
                    .actionLabel(getString(R.string.go_save))
                    .actionColor(Color.RED)
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {
                            Intent intent = new Intent(MainActivity.this,SaveArtActivity.class);
                            startActivity(intent);
                        }
                    })
                , this);
        }
    }


    public void initView(){
        mToolbar = (Toolbar) findViewById(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.inflateMenu(R.menu.menu_toolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    ToastUtil.showLong(getApplicationContext(),"search");
                } else if (menuItemId == R.id.action_notification) {
                    ToastUtil.showLong(getApplicationContext(),"tongzhi");
                }else if(menuItemId == R.id.action_save){
                    Intent intent = new Intent(MainActivity.this,SaveArtActivity.class);
                    startActivity(intent);
                    Log.d(TAG,"save");
                }else if(menuItemId == R.id.action_about){
                    Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }


    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }


    public void switchToFragmnent() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new OneImgFragment();
                    case 1:
                        return new SuJinFragment();
                    case 2:
                        return new QaFragment();
                    default:
                        return new OneImgFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
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
                    default:
                        return getString(R.string.OneImg);
                }
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
