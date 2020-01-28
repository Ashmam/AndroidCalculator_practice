package com.example.a18751.my_calculator.base;


public interface BaseView<T extends BasePresenter> {
    void showLoading(String str);
    void showLoading(char varchar,boolean condition);
    void showLoading(String str,int i);
    void hideLoading();
    void onError(Throwable throwable);
    void setPresenter(T presenter);
}
