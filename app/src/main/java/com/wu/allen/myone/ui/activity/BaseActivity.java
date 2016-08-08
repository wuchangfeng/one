package com.wu.allen.myone.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.wu.allen.myone.MyApp;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;

/**
 * Created by allen on 2016/7/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent(MyApp.get(getApplication()).getAppComponent());
    }

    /**
     * 子类实现该方法用于替代 findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T $(@IdRes int id) {
        return (T)findViewById(id);
    }

    /**
     * 子类实现该方法用于替代 getResources().getString(id) 以及进行相应的类型检查
     * @param id
     * @return
     */
    protected String getStringById(@StringRes int id) {
        return getResources().getString(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_other, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_save){

        }else if (id == R.id.action_about){

        }else if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    protected abstract  void setupFragmentComponent(AppComponent appComponent);
}
