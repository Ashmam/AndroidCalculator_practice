package com.example.a18751.my_calculator.base;


public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    void hideLoading();
    void onError(Throwable throwable);
}
