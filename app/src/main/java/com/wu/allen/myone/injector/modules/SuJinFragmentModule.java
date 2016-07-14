package com.wu.allen.myone.injector.modules;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.presenter.SuJinFragmentPresenter;
import com.wu.allen.myone.ui.fragment.SuJinFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by allen on 2016/7/14.
 */
@Module
public class SuJinFragmentModule {

    private SuJinFragment suJinFragment;

    public SuJinFragmentModule(SuJinFragment suJinFragment) {
        suJinFragment = suJinFragment;
    }

    @Provides
    @FragmentScope
    SuJinFragment provideSuJinFragment(){
        return suJinFragment;
    }

    @Provides
    @FragmentScope
    SuJinFragmentPresenter provideSuJinFragmentPresenter(){
        return new SuJinFragmentPresenter();
    }
}
