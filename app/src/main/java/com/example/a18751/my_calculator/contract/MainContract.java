package com.example.a18751.my_calculator.contract;

import com.example.a18751.my_calculator.base.BaseMainModel;
import com.example.a18751.my_calculator.base.BasePresenter;
import com.example.a18751.my_calculator.base.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {}
    interface Presenter extends BasePresenter<View> {}
    interface Model extends BaseMainModel {}
}
