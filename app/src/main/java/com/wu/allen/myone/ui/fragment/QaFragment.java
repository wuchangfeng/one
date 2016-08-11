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
import com.wu.allen.myone.adapter.QaAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.injector.components.DaggerQaFragmentComponent;
import com.wu.allen.myone.injector.modules.QaFragmentModule;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.presenter.QaFragmentPresenter;
import com.wu.allen.myone.view.IQaView;
import java.util.List;
import javax.inject.Inject;

import static com.wu.allen.myone.R.id.recyclerView;

/**
 * Created by allen on 2016/7/14.
 */

public class QaFragment extends BaseFragment implements IQaView{

    private static final String TAG = "QaFragment";
    private EasyRecyclerView mRecyclerView;
    private QaAdapter mQaAdapter;
    private LinearLayout mLinearLayout;
    private Handler handler = new Handler();
    private int page = 0;

    @Inject QaFragmentPresenter mQaFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qa_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mRecyclerView = (EasyRecyclerView) view.findViewById(recyclerView);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.no_network);
        // TODO: 2016/7/16 can add Adapter to p
        mQaAdapter = new QaAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mQaAdapter);
        mQaAdapter.setMore(R.layout.view_more,this);
        mQaAdapter.setNoMore(R.layout.view_nomore);
        mQaAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mQaFragmentPresenter.getIntentQa(getActivity(),position);
            }
        });
        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQaFragmentPresenter.onAttachView(this);
        mQaFragmentPresenter.onCreate(0);
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerQaFragmentComponent.builder()
            .appComponent(appComponent)
            .qaFragmentModule(new QaFragmentModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mQaFragmentPresenter.onCreate(page);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        page = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mQaAdapter.clear();
                mQaFragmentPresenter.onCreate(page);
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
    public void fillData(List<Qa> list) {
        mQaAdapter.addAll(list);
        mQaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mQaFragmentPresenter != null)
            mQaFragmentPresenter = null;
    }
}
