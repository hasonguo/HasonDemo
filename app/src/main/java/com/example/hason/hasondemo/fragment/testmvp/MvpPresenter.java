package com.example.hason.hasondemo.fragment.testmvp;

import android.content.Context;

import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDataBean;
import com.example.hason.hasondemo.network.NetRequest;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hason on 17/3/31.
 */

public class MvpPresenter implements MvpConstract.Presenter {
    private final MvpConstract.View mView;
    private static final String TAG = "AndroidFragment";
    private static final String TYPE = "mType";
    private String mType = "Android";
    private int mPage = 1;

    public MvpPresenter(MvpConstract.View mView){
        this.mView=mView;
        mView.setPresenter(this);
    }
    @Override
    public void getData(Context mContext) {


    }

    @Override
    public void onRefreshing() {

        Observer<GankIoDataBean> observer = new Observer<GankIoDataBean>() {
            @Override
            public void onCompleted() {
                mView.onComplete();
            }

            @Override
            public void onError(Throwable e){

            }

            @Override
            public void onNext(GankIoDataBean gankIoDataBean) {
                if (mPage == 1) {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
                        mView.onRefreshSuccess(gankIoDataBean.getResults());
                    }
                } else {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {

                    } else {

                    }
                }
            }
        };


        Subscription subscription = NetRequest.getRetrofitHttpClient().getGankIoData(mType, mPage, 20)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        ((MvpFragment)mView).addSubscription(subscription);
    }

    @Override
    public void onLoadMore() {
        mPage++;

        Observer<GankIoDataBean> observer = new Observer<GankIoDataBean>() {
            @Override
            public void onCompleted() {
                mView.onComplete();
            }

            @Override
            public void onError(Throwable e){

            }

            @Override
            public void onNext(GankIoDataBean gankIoDataBean) {
                if (mPage == 1) {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
                        mView.onRefreshSuccess(gankIoDataBean.getResults());
                    }
                } else {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
                        mView.onLoadMoreSuccess(gankIoDataBean.getResults());
                    } else {

                    }
                }
            }
        };


        Subscription subscription = NetRequest.getRetrofitHttpClient().getGankIoData(mType, mPage, 20)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        ((MvpFragment)mView).addSubscription(subscription);

    }
}
