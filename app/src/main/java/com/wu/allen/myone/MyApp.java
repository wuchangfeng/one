package com.wu.allen.myone;

import android.app.Application;
import android.content.Context;
import com.avos.avoscloud.AVOSCloud;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerAppComponent;
import com.wu.allen.myone.injector.modules.AppModule;

/**
 * Created by allen on 2016/7/14.
 */

public class MyApp extends Application {

    private AppComponent appComponent;

    public static MyApp get(Context context){
        return (MyApp)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // this, AppId, AppKey
        AVOSCloud.initialize(this,"aAGVAzmoq42zi6n6ErIcJJJQ-gzGzoHsz","asw2YMxhUxsW0cF9lQlFTJKL");
        appComponent= DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
