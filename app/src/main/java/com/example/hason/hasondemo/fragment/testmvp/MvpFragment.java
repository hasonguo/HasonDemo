package com.example.hason.hasondemo.fragment.testmvp;

import android.support.v7.widget.RecyclerView;

import com.example.hason.hasondemo.base.fragment.BaseRecyclerFragment;
import com.example.hason.hasondemo.base.adapter.BaseRecyclerAdapter;
import com.example.hason.hasondemo.fragment.testmvp.adapter.MvpAdapter;
import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDataBean;

/**
 * Created by hason on 17/3/30.
 */

public class MvpFragment extends BaseRecyclerFragment<MvpConstract.Presenter, GankIoDataBean.ResultBean> implements  BaseRecyclerAdapter.OnItemLongClickListener,MvpConstract.View {


    @Override
    protected BaseRecyclerAdapter<GankIoDataBean.ResultBean> getAdapter() {
        return new MvpAdapter(mContext);
    }

    @Override
    protected void onItemClick(GankIoDataBean.ResultBean resultBean, int position) {

    }


    @Override
    protected void initData() {
        mPresenter.getData(mContext);
        super.initData();
        mAdapter.setOnItemLongClickListener(this);
    }

    @Override
    public void onLongClick(int position, long itemId) {

    }
}
