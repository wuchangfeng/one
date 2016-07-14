package com.wu.allen.myone.injector.modules;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.presenter.OneImgFragmentPresenter;
import com.wu.allen.myone.ui.fragment.OneImgFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by allen on 2016/7/14.
 */
@Module
public class OneImgFragmentModule {

    private OneImgFragment oneImgFragment;
    public OneImgFragmentModule(OneImgFragment oneImgFragment) {
        oneImgFragment = oneImgFragment;
    }

    @Provides
    @FragmentScope
    OneImgFragment provideOneImgFragment(){
        return oneImgFragment;
    }

    @Provides
    @FragmentScope
    OneImgFragmentPresenter provideOneImgFragmentPresenter(){
        return new OneImgFragmentPresenter();
    }
}
