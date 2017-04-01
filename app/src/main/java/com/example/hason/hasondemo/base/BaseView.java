package com.example.hason.hasondemo.base;


public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);

    void showNetworkError(int strId);
}
