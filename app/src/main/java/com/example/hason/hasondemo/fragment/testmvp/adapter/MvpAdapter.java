package com.example.hason.hasondemo.fragment.testmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.hason.hasondemo.R;
import com.example.hason.hasondemo.base.adapter.BaseRecyclerAdapter;
import com.example.hason.hasondemo.fragment.testmvp.bean.AndroidBean;
import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDataBean;
import com.example.hason.hasondemo.util.TimeUtil;

import java.util.List;
/**
 * Created by hason on 17/3/31.
 */

public class MvpAdapter extends BaseRecyclerAdapter<GankIoDataBean.ResultBean> {

    public MvpAdapter(Context context) {
        super(context, ONLY_FOOTER);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new MvpViewHolder(mInflater.inflate(R.layout.item_list_mvp, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, GankIoDataBean.ResultBean item, int position) {
        MvpViewHolder h = (MvpViewHolder) holder;

        if (item != null) {
            // read resultsBean.publishedAt
            String publishedAtResultsBe = item.getPublishedAt();
            // read resultsBean.who
            String whoResultsBean = item.getWho();
            // read resultsBean.desc
            String descResultsBean = item.getDesc();
            ((MvpViewHolder) holder).mUserText.setText(whoResultsBean);
            ((MvpViewHolder) holder).mTitleView.setText(descResultsBean);
            ((MvpViewHolder) holder).mFavCountText.setText(TimeUtil.getTranslateTime(publishedAtResultsBe));
        }
    }

    private class MvpViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleView, mUserText, mFavCountText;

        public MvpViewHolder(View itemView) {
            super(itemView);
            mTitleView = (TextView) itemView.findViewById(R.id.tv_title);
            mUserText = (TextView) itemView.findViewById(R.id.tv_user);
            mFavCountText = (TextView) itemView.findViewById(R.id.tv_fav_date);
        }
    }
}
