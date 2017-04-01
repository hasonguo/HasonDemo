package com.example.hason.hasondemo;

import android.os.Bundle;
import android.util.Log;

import com.example.hason.hasondemo.base.BaseActivity;
import com.example.hason.hasondemo.fragment.testmvp.MvpFragment;
import com.example.hason.hasondemo.fragment.testmvp.MvpPresenter;
import com.example.hason.hasondemo.fragment.testmvp.bean.AndroidBean;
import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDataBean;
import com.example.hason.hasondemo.fragment.testmvp.bean.GankIoDayBean;
import com.example.hason.hasondemo.network.NetRequest;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initWidget() {
        super.initWidget();
        MvpFragment mvpFragment = new MvpFragment();
        addFragment(R.id.fl_content, mvpFragment);
        MvpPresenter mvpPresenter = new MvpPresenter(mvpFragment);

    }
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
