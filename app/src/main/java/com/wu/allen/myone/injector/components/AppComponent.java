package com.wu.allen.myone.injector.components;

import android.app.Application;
import com.wu.allen.myone.injector.modules.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by allen on 2016/7/14.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application getApplication();
}
