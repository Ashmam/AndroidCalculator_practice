package com.example.a18751.my_calculator.base;

public interface BasePresenter<T extends BaseView> {

    /**
     * 绑定view
     * @param view
     */
    void attachView(T view);

    /**
     * 解绑view
     */
    void detachView();

    /**
     * 是否绑定view
     * @return
     */
    boolean isViewAttach();

    /**
     * 初始化
     */
    void start();
}
