package com.wu.allen.myone.injector.modules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by allen on 2016/7/14.
 */
@Module
public class AppModule {

    private Application application;


    public AppModule(Application application){
        this.application=application;
    }


    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }
}
