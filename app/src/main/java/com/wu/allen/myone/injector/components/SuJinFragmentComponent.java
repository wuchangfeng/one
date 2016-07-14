package com.wu.allen.myone.injector.components;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.injector.modules.SuJinFragmentModule;
import com.wu.allen.myone.ui.fragment.SuJinFragment;
import dagger.Component;

/**
 * Created by allen on 2016/7/14.
 */
@FragmentScope
@Component(modules = SuJinFragmentModule.class,dependencies = AppComponent.class)
public interface SuJinFragmentComponent {

    //SuJinFragment inject(SuJinFragment suJinFragment);
    SuJinFragment inject(SuJinFragment suJinFragment);
}
