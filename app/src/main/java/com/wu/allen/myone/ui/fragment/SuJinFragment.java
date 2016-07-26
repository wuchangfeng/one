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
import com.wu.allen.myone.adapter.SuJinAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerSuJinFragmentComponent;
import com.wu.allen.myone.injector.modules.SuJinFragmentModule;
import com.wu.allen.myone.model.Article;
import com.wu.allen.myone.presenter.SuJinFragmentPresenter;
import com.wu.allen.myone.view.ISuJinView;
import java.util.List;
import javax.inject.Inject;

import static com.wu.allen.myone.R.id.recyclerView;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinFragment extends BaseFragment implements ISuJinView{

    private static final String TAG = "SuJinFragment";
    private EasyRecyclerView mRecyclerView;
    private SuJinAdapter mSuJinAdapter;
    private LinearLayout mLinearLayout;
    private Handler handler = new Handler();
    private int page = 0;

    @Inject
    SuJinFragmentPresenter mSuJinFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mRecyclerView = (EasyRecyclerView) view.findViewById(recyclerView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.no_network);
        mSuJinAdapter = new SuJinAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mSuJinAdapter);
        mSuJinAdapter.setMore(R.layout.view_more,this);
        mSuJinAdapter.setNoMore(R.layout.view_nomore);
        mSuJinAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
              mSuJinFragmentPresenter.getIntentArticle(getActivity(),position);
            }
        });
        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSuJinFragmentPresenter.onAttachView(this);
        mSuJinFragmentPresenter.onCreate(0);
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerSuJinFragmentComponent.builder()
            .appComponent(appComponent)
            .suJinFragmentModule(new SuJinFragmentModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mSuJinFragmentPresenter.onCreate(page);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        page = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSuJinAdapter.clear();
                mSuJinFragmentPresenter.onCreate(page);
                page=1;
            }
        }, 1000);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void errorLayoutShow() {
        mLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void fillData(List<Article> list) {
        mSuJinAdapter.addAll(list);
        mSuJinAdapter.notifyDataSetChanged();
    }
}
