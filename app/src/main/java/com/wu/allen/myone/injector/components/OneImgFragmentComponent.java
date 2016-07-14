package com.wu.allen.myone.injector.components;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.injector.modules.OneImgFragmentModule;
import com.wu.allen.myone.ui.fragment.OneImgFragment;
import dagger.Component;

/**
 * Created by allen on 2016/7/14.
 */
@FragmentScope
@Component(modules = OneImgFragmentModule.class,dependencies = AppComponent.class)
public interface OneImgFragmentComponent {

    OneImgFragment inject(OneImgFragment oneImgFragment);
}
