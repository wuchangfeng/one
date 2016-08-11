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
import com.wu.allen.myone.adapter.OneImgAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerOneImgFragmentComponent;
import com.wu.allen.myone.injector.modules.OneImgFragmentModule;
import com.wu.allen.myone.model.One;
import com.wu.allen.myone.presenter.OneImgFragmentPresenter;
import com.wu.allen.myone.view.IOneView;
import java.util.List;
import javax.inject.Inject;

import static com.wu.allen.myone.R.id.recyclerView;

/**
 * Created by allen on 2016/7/14.
 */

public class OneImgFragment extends BaseFragment implements IOneView{

    private static final String TAG = "OneImgFragment";
    private EasyRecyclerView mRecyclerView;
    private OneImgAdapter mOneImgAdapter;
    private LinearLayout mLinearLayout;
    private Handler handler = new Handler();
    private int page = 0;

    @Inject OneImgFragmentPresenter mOneImgFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oneimg_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mRecyclerView = (EasyRecyclerView) view.findViewById(recyclerView);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.no_network);
        mOneImgAdapter = new OneImgAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mOneImgAdapter);
        mOneImgAdapter.setMore(R.layout.view_more,this);
        mOneImgAdapter.setNoMore(R.layout.view_nomore);
        mOneImgAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // TODO: 2016/7/16  you can do sth with this
            }
        });
        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOneImgFragmentPresenter.onAttachView(this);
        mOneImgFragmentPresenter.onCreate(0);
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerOneImgFragmentComponent.builder()
            .appComponent(appComponent)
            .oneImgFragmentModule(new OneImgFragmentModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mOneImgFragmentPresenter.onCreate(page);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        page = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mOneImgAdapter.clear();
                mOneImgFragmentPresenter.onCreate(page);
                page=1;
            }
        }, 1000);
    }

    @Override
    public void showLoading() {
        // EasyRecyclerView has done this for us
    }

    @Override
    public void hideLoading() {
        // EasyRecyclerView has done this for us
    }

    @Override
    public void errorLayoutShow() {
        mLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void fillData(List<One> list) {
        mOneImgAdapter.addAll(list);
        mOneImgAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mOneImgFragmentPresenter != null)
            mOneImgFragmentPresenter = null;
    }
}
