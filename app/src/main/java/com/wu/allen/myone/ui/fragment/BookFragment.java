package com.wu.allen.myone.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.R;
import com.wu.allen.myone.adapter.BookAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerBookFragmentComponent;
import com.wu.allen.myone.injector.modules.BookFragmentModule;
import com.wu.allen.myone.model.Book;
import com.wu.allen.myone.presenter.BookFragmentPresenter;
import com.wu.allen.myone.view.IBookView;
import java.util.List;
import javax.inject.Inject;

import static com.wu.allen.myone.R.id.recyclerView;

/**
 * Created by allen on 2016/8/10.
 */

public class BookFragment extends BaseFragment implements IBookView {

    private static final String TAG = "BookFragment";
    private EasyRecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private LinearLayout mLinearLayout;
    private Handler handler = new Handler();
    private int page = 0;

    @Inject BookFragmentPresenter mBookFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mRecyclerView = (EasyRecyclerView) view.findViewById(recyclerView);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.no_network);
        mBookAdapter = new BookAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mBookAdapter);
        mBookAdapter.setMore(R.layout.view_more,this);
        mBookAdapter.setNoMore(R.layout.view_nomore);
        mBookAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Log.d(TAG,"onclick");
                //mBookFragmentPresenter.getBookIntr(getActivity(),position);
            }
        });
        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookFragmentPresenter.onAttachView(this);
        mBookFragmentPresenter.onCreate(0);
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerBookFragmentComponent.builder()
            .appComponent(appComponent)
            .bookFragmentModule(new BookFragmentModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mBookFragmentPresenter.onCreate(page);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        page = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBookAdapter.clear();
                mBookFragmentPresenter.onCreate(page);
                page=1;
            }
        }, 1000);
    }

    @Override
    public void errorLayoutShow() {
        mLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void fillData(List<Book> list) {
        mBookAdapter.addAll(list);
        mBookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mBookFragmentPresenter != null)
            mBookFragmentPresenter = null;
    }
}
