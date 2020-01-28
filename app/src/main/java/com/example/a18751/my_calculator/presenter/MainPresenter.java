package com.example.a18751.my_calculator.presenter;

import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.model.MainModel;
import com.example.a18751.my_calculator.util.JudgeUtil;

import java.text.DecimalFormat;


/**
 * @version: 10.0.2
 * @program: XiaoMiCalculator
 * @Package: com.example.a18751.xiaomicalculator.presenter
 * @className: MainPresenter
 * @description: MainPresenter
 * @author: ZJH
 * @create: 2020-01-25 21:50
 **/
public class MainPresenter<T extends MainContract.View> implements MainContract.Presenter {

    private MainModel mmodel;
    private MainContract.View mView;
    private boolean condition;
    private char lastChar;

    public MainPresenter(){
        this.condition=false;
    }

    public MainPresenter(MainContract.View view) {
        this.mView = view;
        this.condition = false;
    }

    public void setMmodel(EquationBean equation) {
        this.mmodel = new MainModel(equation);
    }

    public void output(){
        mView.showLoading(String.valueOf(new DecimalFormat("#.####")
                .format(Double.parseDouble(this.mmodel.getResultBean().getResult()))));
    }

    public void updateEditText(char varchar) {

        if (!this.condition) {
            if (JudgeUtil.isOperator(varchar)||varchar=='.')
                this.condition = true;
        }

        if (!JudgeUtil.isOperator(varchar)&&varchar!='.'){
            mView.showLoading(varchar, this.condition);
        }
        else if (!JudgeUtil.isOperator(this.lastChar)&&this.lastChar!='.'){
            mView.showLoading(varchar, this.condition);
        }

        this.condition = true;
        this.lastChar=varchar;
    }

    public void percentOperator(String equation){
        int counter=0;
        if (!JudgeUtil.isOperator(this.lastChar)&&this.lastChar!='.'){
            for (int i=equation.length()-1;i>=0;i--) {
                if (JudgeUtil.isOperator(equation.charAt(i))){
                    counter=i;
                    break;
                }
            }
            String str=equation.substring(counter+1);
            double num=Double.parseDouble(str)/100;
            //System.out.println(new StringBuffer(equation).replace(counter+1,equation.length(), new DecimalFormat("#.####").format(num)));
            mView.showLoading(String.valueOf(new StringBuffer(equation).replace(counter+1,equation.length(), new DecimalFormat("#.####").format(num))),1);
        }
    }

    @Override
    public void attachView(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public boolean isViewAttach() {
        if (this.mView == null)
            return false;
        else
            return true;
    }

    @Override
    public void start() {
        this.mmodel = null;
        this.condition = false;
    }

}
