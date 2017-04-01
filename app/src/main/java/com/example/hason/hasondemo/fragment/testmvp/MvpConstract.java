package com.example.hason.hasondemo.fragment.testmvp;

import android.content.Context;

import com.example.hason.hasondemo.base.BaseListPresenter;
import com.example.hason.hasondemo.base.BaseListView;
import com.example.hason.hasondemo.base.BasePresenter;
import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDataBean;

/**
 * Created by hason on 17/3/30.
 */

interface MvpConstract {
    interface View extends BaseListView<Presenter, GankIoDataBean.ResultBean>{

    }
    interface Presenter extends BaseListPresenter {
       void getData(Context mContext);

    }
}
