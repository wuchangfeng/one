package com.wu.allen.myone.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
