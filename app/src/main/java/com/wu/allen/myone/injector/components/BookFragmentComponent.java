package com.wu.allen.myone.injector.components;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.injector.modules.BookFragmentModule;
import com.wu.allen.myone.ui.fragment.BookFragment;
import dagger.Component;

/**
 * Created by allen on 2016/8/10.
 */
@FragmentScope
@Component(modules = BookFragmentModule.class,dependencies = AppComponent.class)
public interface BookFragmentComponent {

    //SuJinFragment inject(SuJinFragment suJinFragment);
    BookFragment inject(BookFragment bookFragment);
}
