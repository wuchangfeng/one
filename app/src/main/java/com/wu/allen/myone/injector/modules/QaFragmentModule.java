package com.wu.allen.myone.injector.modules;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.presenter.QaFragmentPresenter;
import com.wu.allen.myone.ui.fragment.QaFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by allen on 2016/7/15.
 */
@Module
public class QaFragmentModule {

    private QaFragment qaFragment;
    public QaFragmentModule(QaFragment qaFragment) {
        qaFragment = qaFragment;
    }

    @Provides
    @FragmentScope
    QaFragment provideQaFragment(){
        return qaFragment;
    }

    @Provides
    @FragmentScope
    QaFragmentPresenter provideQaFragmentPresenter(){
        return new QaFragmentPresenter();
    }
}
