package com.example.a18751.my_calculator.contract;

import com.example.a18751.my_calculator.base.BaseMainModel;
import com.example.a18751.my_calculator.base.BasePresenter;
import com.example.a18751.my_calculator.base.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void showResult(String str);
        void showInput(char varchar, boolean condition);
        void showPercent(String str);
    }
    interface Presenter extends BasePresenter<View> {
        void updateEditText(char varchar);
        void percentOperator(String equation);
        void output();
    }
    interface Model extends BaseMainModel {

    }
}
