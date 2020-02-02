package com.example.a18751.my_calculator.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.example.a18751.my_calculator.base.BaseLoginModel;
import com.example.a18751.my_calculator.base.BasePresenter;
import com.example.a18751.my_calculator.base.BaseView;

/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.contract
 * @className: LoginContract
 * @description: Login contract
 * @author: Ashmam
 * @create: 2020-02-03 02:42
 **/
public interface LoginContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter<View> {
    }

    interface Model extends BaseLoginModel {
    }
}
