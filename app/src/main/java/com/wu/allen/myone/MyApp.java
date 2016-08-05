package com.wu.allen.myone;

import android.app.Application;
import android.content.Context;
import com.avos.avoscloud.AVOSCloud;
import com.tencent.bugly.crashreport.CrashReport;
import com.wu.allen.myone.config.AppConstant;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerAppComponent;
import com.wu.allen.myone.injector.modules.AppModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

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

        // for bugly
        CrashReport.initCrashReport(getApplicationContext(), AppConstant.BUGLYID, false);

        // for leancloud
        AVOSCloud.initialize(this, AppConstant.LEANCLOUD_KEY,AppConstant.LEANCLOUD_SERCERT);

        // for dagger2
        appComponent= DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .build();

        // for realm
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
            .deleteRealmIfMigrationNeeded()
            .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
