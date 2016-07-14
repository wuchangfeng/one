package com.wu.allen.myone.injector.components;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.injector.modules.QaFragmentModule;
import com.wu.allen.myone.ui.fragment.QaFragment;
import dagger.Component;

/**
 * Created by allen on 2016/7/15.
 */
@FragmentScope
@Component(modules = QaFragmentModule.class,dependencies = AppComponent.class)
public interface QaFragmentComponent {

    QaFragment inject(QaFragment QaFragment);
}
