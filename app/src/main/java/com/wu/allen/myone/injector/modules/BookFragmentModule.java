package com.wu.allen.myone.injector.modules;

import com.wu.allen.myone.injector.FragmentScope;
import com.wu.allen.myone.presenter.BookFragmentPresenter;
import com.wu.allen.myone.ui.fragment.BookFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by allen on 2016/8/10.
 */
@Module
public class BookFragmentModule {

    private BookFragment bookFragment;

    public BookFragmentModule(BookFragment bookFragment) {
        bookFragment = bookFragment;
    }

    @Provides
    @FragmentScope
    BookFragment provideBookFragment(){
        return bookFragment;
    }

    @Provides
    @FragmentScope
    BookFragmentPresenter provideBookFragmentPresenter(){
        return new BookFragmentPresenter();
    }
}
